package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.ProductPage;
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
    }

    public String getUserName() {
        return loginPage.getUserName();
    }

    public void doXistoreWrongMail(String email, String password) {
        loginPage.openLoginForm();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.interSubmit();
    }

    public String getLabelError() {
        return loginPage.getLabelError();
    }

    public void doXistoreWrongPassword(String email, String password) {
        loginPage.openLoginForm();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.interSubmit();
    }

    public void doXistoreWrongMailPassword(String email, String password) {
        loginPage.openLoginForm();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.interSubmit();
    }

    public void doXistoreEmptyFieldsMailPassword(String email, String password) {
        loginPage.openLoginForm();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.interSubmit();
    }

//    public boolean doXistoreEmptyFieldsMailPassword() {
//        driver.findElement(By.xpath(XistorePage.BTN_ENTER)).click();
//        WebElement inputMail = driver.findElement(By.xpath(XistorePage.INPUT_MAIL));
//        inputMail.sendKeys(" ");
//        WebElement inputPassword = driver.findElement(By.xpath(XistorePage.INPUT_PASSWORD));
//        inputPassword.sendKeys(" ");
//        driver.findElement(By.xpath(XistorePage.BTN_INTER_SUBMIT)).click();
//        String labelError = driver.findElement(By.xpath(XistorePage.LOGIN_WRONG_MAIL)).getText();
//        System.out.println(labelError);
//        System.out.println("Неверный логин или пароль.");
//        return labelError.equals("Неверный логин или пароль.");
//    }
//    ProductPage productPage = new ProductPage();
//
//    public void doXistoreCart(String namePhone, String namePhoneInCart) {

        public boolean doXistoreCart() {
        driver.findElement(By.xpath(XistorePage.BTN_CATALOG_PHONE)).click();
        driver.findElement(By.xpath(XistorePage.SELECTION_PHONE)).click();
        String[] title = driver.findElement(By.xpath(XistorePage.NAME_PHONE)).getText().split("\n");
        String namePhone = title[0];
        //System.out.println(namePhone);
        driver.findElement(By.xpath(XistorePage.BTN_PLACE_AN_ORDER_CART)).click();
        driver.findElement(By.xpath(XistorePage.BTN_CLOSE)).click();
        driver.findElement(By.xpath(XistorePage.BTN_INPUT_CART)).click();
        String namePhoneInCart = driver.findElement(By.xpath(XistorePage.NAME_PHONE_IN_CART)).getText();
        //System.out.println(namePhoneInCart);
        return namePhoneInCart.contains(namePhone);
        // Assertions.assertTrue(namePhoneInCart.contains(namePhone));

    }


}
