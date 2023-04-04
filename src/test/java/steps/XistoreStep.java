package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.XistorePage;

public class XistoreStep {
    WebDriver driver;

    public XistoreStep(WebDriver driver) {
        this.driver = driver;

    }
    LoginPage loginPage = new LoginPage();

    public void doXistoreLogin(String email, String password) {

        loginPage.openLoginForm();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.interSubmit();
        loginPage.checkRegistrashion();

//        driver.findElement(By.xpath(XistorePage.BTN_ENTER)).click();
//        WebElement inputMail = driver.findElement(By.xpath(XistorePage.INPUT_MAIL));
//        inputMail.sendKeys(UserPage.EMAIL);
//        WebElement inputPassword = driver.findElement(By.xpath(XistorePage.INPUT_PASSWORD));
//        inputPassword.sendKeys(UserPage.PASSWORD);
//        driver.findElement(By.xpath(XistorePage.BTN_INTER_SUBMIT)).click();
//        driver.findElement(By.xpath(XistorePage.BTN_CHECK_REGISTRATION)).click();
//        String labelName = driver.findElement(By.xpath(XistorePage.LINK_MAIL)).getText();
//        String labelName = loginPage.checkRegistrashion();
//         System.out.println(labelName);
//         System.out.println(UserPage.EMAIL);
//         return labelName.equals(UserPage.EMAIL);
    }
    public boolean doXistoreWrongMail() {

        driver.findElement(By.xpath(XistorePage.BTN_ENTER)).click();
        WebElement inputMail = driver.findElement(By.xpath(XistorePage.INPUT_MAIL));
        inputMail.sendKeys("ppp");
        WebElement inputPassword = driver.findElement(By.xpath(XistorePage.INPUT_PASSWORD));
        inputPassword.sendKeys("10293847ppp");
        driver.findElement(By.xpath(XistorePage.BTN_INTER_SUBMIT)).click();
        String labelError = driver.findElement(By.xpath(XistorePage.LOGIN_WRONG_MAIL)).getText();
        return  labelError.equals("Неверный логин или пароль.");
    }
    public boolean doXistoreWrongPassword(){

        driver.findElement(By.xpath(XistorePage.BTN_ENTER)).click();
        WebElement inputMail = driver.findElement(By.xpath(XistorePage.INPUT_MAIL));
        inputMail.sendKeys("ppp694185@gmail.com");
        WebElement inputPassword = driver.findElement(By.xpath(XistorePage.INPUT_PASSWORD));
        inputPassword.sendKeys("10293847");
        driver.findElement(By.xpath(XistorePage.BTN_INTER_SUBMIT)).click();
        String labelError =driver.findElement(By.xpath(XistorePage.LOGIN_WRONG_MAIL)).getText();
        // System.out.println(labelError);
        // System.out.println("Неверный логин или пароль.");
        return labelError.equals("Неверный логин или пароль.");
        //Assertions.assertEquals("Неверный логин или пароль.",labelError);
    }
    public boolean doXistoreWrongMailPassword() {

        driver.findElement(By.xpath(XistorePage.BTN_ENTER)).click();
        WebElement inputMail = driver.findElement(By.xpath(XistorePage.INPUT_MAIL));
        inputMail.sendKeys("ppp");
        WebElement inputPassword = driver.findElement(By.xpath(XistorePage.INPUT_PASSWORD));
        inputPassword.sendKeys("10293847");
        driver.findElement(By.xpath(XistorePage.BTN_INTER_SUBMIT)).click();
        //Util.waitThreadFor(2);
        String labelError = driver.findElement(By.xpath(XistorePage.LOGIN_WRONG_MAIL)).getText();
        System.out.println(labelError);
        System.out.println("Неверный логин или пароль.");
        return labelError.equals("Неверный логин или пароль.");
       // Assertions.assertEquals("Неверный логин или пароль.", labelError);

    }
    public boolean doXistoreEmptyFieldsMailPassword() {

        driver.findElement(By.xpath(XistorePage.BTN_ENTER)).click();
        WebElement inputMail = driver.findElement(By.xpath(XistorePage.INPUT_MAIL));
        inputMail.sendKeys(" ");
        WebElement inputPassword = driver.findElement(By.xpath(XistorePage.INPUT_PASSWORD));
        inputPassword.sendKeys(" ");
        driver.findElement(By.xpath(XistorePage.BTN_INTER_SUBMIT)).click();
      //  Util.waitTimeFor(2);
        String labelError = driver.findElement(By.xpath(XistorePage.LOGIN_WRONG_MAIL)).getText();
        System.out.println(labelError);
        System.out.println("Неверный логин или пароль.");
        return labelError.equals("Неверный логин или пароль.");
       // Assertions.assertEquals("Неверный логин или пароль.", labelError);
    }
    public boolean doXistoreCart() {
      //  Util.waitTimeFor(3);
        driver.findElement(By.xpath(XistorePage.BTN_CATALOG_PHONE)).click();
      //  Util.waitTimeFor(3);
        driver.findElement(By.xpath(XistorePage.SELECTION_PHONE)).click();
      //  Util.waitTimeFor(3);
        String[] title = driver.findElement(By.xpath(XistorePage.NAME_PHONE)).getText().split("\n");
        String namePhone = title[0];
        System.out.println(namePhone);
        driver.findElement(By.xpath(XistorePage.BTN_PLACE_AN_ORDER_CART)).click();
      //  Util.waitTimeFor(2);
        driver.findElement(By.xpath(XistorePage.BTN_CLOSE)).click();
      //  Util.waitTimeFor(2);
        driver.findElement(By.xpath(XistorePage.BTN_INPUT_CART)).click();
        String namePhoneInCart = driver.findElement(By.xpath(XistorePage.NAME_PHONE_IN_CART)).getText();
        System.out.println(namePhoneInCart);
        return namePhoneInCart.contains(namePhone);
       // Assertions.assertTrue(namePhoneInCart.contains(namePhone));
    }
    public String getUserName() {
        return loginPage.getUserName();
    }



}
