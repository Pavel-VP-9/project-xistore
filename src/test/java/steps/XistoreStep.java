package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public boolean doXistoreCart() {
        driver.findElement(By.xpath(XistorePage.BTN_CATALOG_PHONE)).click();
        driver.findElement(By.xpath(XistorePage.SELECTION_PHONE)).click();
        String[] title = driver.findElement(By.xpath(XistorePage.NAME_PHONE)).getText().split("\n");
        String namePhone = title[0];
        driver.findElement(By.xpath(XistorePage.BTN_PLACE_AN_ORDER_CART)).click();
        driver.findElement(By.xpath(XistorePage.BTN_CLOSE)).click();
        driver.findElement(By.xpath(XistorePage.BTN_INPUT_CART)).click();
        String namePhoneInCart = driver.findElement(By.xpath(XistorePage.NAME_PHONE_IN_CART)).getText();
        return namePhoneInCart.contains(namePhone);

    }

}
