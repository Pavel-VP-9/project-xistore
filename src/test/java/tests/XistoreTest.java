package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.XistorePage;
import util.Util;

import java.time.Duration;
import java.util.List;

public class XistoreTest {


    WebDriver driver;

    @BeforeEach
    public void warmUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(XistorePage.URL);
    }

    @Test
    public void testXistoreLogin() {
        driver.findElement(By.xpath(XistorePage.BTN_ENTER)).click();
        WebElement inputMail = driver.findElement(By.xpath(XistorePage.INPUT_MAIL));
        inputMail.sendKeys("ppp694185@gmail.com");
        WebElement inputPassword = driver.findElement(By.xpath(XistorePage.INPUT_PASSWORD));
        inputPassword.sendKeys("10293847ppp");
        driver.findElement(By.xpath(XistorePage.BTN_INTER_SUBMIT)).click();
        Util.waitThreadFor(2);
        driver.findElement(By.xpath(XistorePage.BTN_CHECK_REGISTRATION)).click();
        String labelName = driver.findElement(By.xpath(XistorePage.LINK_MAIL)).getText();
        //System.out.println(labelName);
        //System.out.println("ppp694185@gmail.com");
        Assertions.assertEquals("ppp694185@gmail.com", labelName);
    }

    @Test
    public void testXitoreWrongMail() {
        driver.findElement(By.xpath(XistorePage.BTN_ENTER)).click();
        WebElement inputMail = driver.findElement(By.xpath(XistorePage.INPUT_MAIL));
        inputMail.sendKeys("ppp");
        WebElement inputPassword = driver.findElement(By.xpath(XistorePage.INPUT_PASSWORD));
        inputPassword.sendKeys("10293847ppp");
        driver.findElement(By.xpath(XistorePage.BTN_INTER_SUBMIT)).click();
        Util.waitThreadFor(2);
        String labelError =driver.findElement(By.xpath(XistorePage.LOGIN_WRONG_MAIL)).getText();
        //System.out.println(labelError);
        //System.out.println("Неверный логин или пароль.");
        Assertions.assertEquals("Неверный логин или пароль.",labelError);

    }
    @Test
    public void testXitoreWrongPassword() {
        driver.findElement(By.xpath(XistorePage.BTN_ENTER)).click();
        WebElement inputMail = driver.findElement(By.xpath(XistorePage.INPUT_MAIL));
        inputMail.sendKeys("ppp694185@gmail.com");
        WebElement inputPassword = driver.findElement(By.xpath(XistorePage.INPUT_PASSWORD));
        inputPassword.sendKeys("10293847");
        driver.findElement(By.xpath(XistorePage.BTN_INTER_SUBMIT)).click();
        Util.waitThreadFor(2);
        String labelError =driver.findElement(By.xpath(XistorePage.LOGIN_WRONG_MAIL)).getText();
       // System.out.println(labelError);
       // System.out.println("Неверный логин или пароль.");
        Assertions.assertEquals("Неверный логин или пароль.",labelError);


    }
    @Test
    public void testXitoreWrongMailPassword() {
        driver.findElement(By.xpath(XistorePage.BTN_ENTER)).click();
        WebElement inputMail = driver.findElement(By.xpath(XistorePage.INPUT_MAIL));
        inputMail.sendKeys("ppp");
        WebElement inputPassword = driver.findElement(By.xpath(XistorePage.INPUT_PASSWORD));
        inputPassword.sendKeys("10293847");
        driver.findElement(By.xpath(XistorePage.BTN_INTER_SUBMIT)).click();
        Util.waitThreadFor(2);
        String labelError = driver.findElement(By.xpath(XistorePage.LOGIN_WRONG_MAIL)).getText();
        System.out.println(labelError);
        System.out.println("Неверный логин или пароль.");
        Assertions.assertEquals("Неверный логин или пароль.", labelError);
    }
    @Test
    public void testXitoreWrongMailPassword1() {
        driver.findElement(By.xpath(XistorePage.BTN_ENTER)).click();
        WebElement inputMail = driver.findElement(By.xpath(XistorePage.INPUT_MAIL));
        inputMail.sendKeys("");
        WebElement inputPassword = driver.findElement(By.xpath(XistorePage.INPUT_PASSWORD));
        inputPassword.sendKeys("");
        driver.findElement(By.xpath(XistorePage.BTN_INTER_SUBMIT)).click();
        Util.waitTimeFor(2);
        String labelError = driver.findElement(By.xpath(XistorePage.LOGIN_WRONG_MAIL)).getText();
        System.out.println(labelError);
        // System.out.println("Неверный логин или пароль.");
        Assertions.assertEquals("Неверный логин или пароль.", labelError);
    }

    @Test
    public void testXitoreCart()  {
        Util.waitTimeFor(3);
        driver.findElement(By.xpath(XistorePage.BTN_CATALOG_PHONE)).click();
        Util.waitTimeFor(3);
        driver.findElement(By.xpath(XistorePage.SELECTION_PHONE)).click();
        Util.waitTimeFor(3);
        String[] title = driver.findElement(By.xpath(XistorePage.NAME_PHONE)).getText().split("\n");
        String namePhone = title[0];
       // System.out.println(namePhone);
        driver.findElement(By.xpath(XistorePage.BTN_PLACE_AN_ORDER_CART)).click();
        Util.waitTimeFor(2);
        driver.findElement(By.xpath(XistorePage.BTN_CLOSE)).click();
        Util.waitTimeFor(2);
        driver.findElement(By.xpath(XistorePage.BTN_INPUT_CART)).click();
        String namePhoneInCart = driver.findElement(By.xpath(XistorePage.NAME_PHONE_IN_CART)).getText();
       // System.out.println(namePhoneInCart);
        Assertions.assertTrue(namePhoneInCart.contains(namePhone));
    }
    @Test
    public void testProductSearch(){
        WebElement inputNameProduct = driver.findElement(By.xpath(XistorePage.INPUT_NAME_PRODUCT));
        inputNameProduct.sendKeys("Xiaomi Redmi Note 11");
        String nameMyProduct = "Xiaomi Redmi Note 11";
        Util.waitTimeFor(2);
        driver.findElement(By.xpath(XistorePage.BTN_SEARCH)).click();
        List<WebElement> listLinkOfPhone = driver.findElements(By.xpath(XistorePage.LIST_LINK_MOBILE_PHONE));
        Assertions.assertFalse(listLinkOfPhone.isEmpty());
        System.out.println(listLinkOfPhone.isEmpty());
        String firstPhone = listLinkOfPhone.get(0).getText();
        System.out.println(firstPhone);
        Assertions.assertTrue(firstPhone.contains(nameMyProduct));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
