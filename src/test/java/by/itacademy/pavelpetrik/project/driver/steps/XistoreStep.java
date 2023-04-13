package by.itacademy.pavelpetrik.project.driver.steps;

import by.itacademy.pavelpetrik.project.driver.pages.UserPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import by.itacademy.pavelpetrik.project.driver.pages.LoginPage;
import by.itacademy.pavelpetrik.project.driver.pages.XistorePage;
import org.openqa.selenium.WebElement;

import java.util.List;

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
        loginPage.refreshPage();
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

    public String doProductSearch() {
        driver.findElement(By.xpath(XistorePage.INPUT_NAME_PRODUCT)).sendKeys(UserPage.NAME_PRODUCT_FOR_SEARCH);
        driver.findElement(By.xpath(XistorePage.BTN_SEARCH)).click();
        List<WebElement> listLinkOfPhone = driver.findElements(By.xpath(XistorePage.LIST_LINK_MOBILE_PHONE));
        Assertions.assertFalse(listLinkOfPhone.isEmpty());
        String firstPhone = listLinkOfPhone.get(0).getText();
        return firstPhone;

    }

}
