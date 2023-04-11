package tests;

import driver.DriverSetup;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.UserPage;
import pages.XistorePage;
import steps.XistoreStep;

import java.util.List;

public class XistoreTest {

    WebDriver driver = DriverSetup.getDriver();

    @BeforeEach
    public void warmUp() {
        driver.get(XistorePage.URL);
    }

    @Test
    @DisplayName("Проверка входа с корректными данными (электронная почта и пароль)")
    public void testXistoreLogin() {
        XistoreStep xistoreStep = new XistoreStep(driver);
        xistoreStep.doXistoreLogin(UserPage.EMAIL, UserPage.PASSWORD);
        Assertions.assertEquals(UserPage.EMAIL, xistoreStep.getUserName());
    }

    @Test
    @DisplayName("Проверка входа с некорректными данными (электронная почта) и корректными данными (пароль)")
    public void testXistoreWrongMail() {
        XistoreStep xistoreStep = new XistoreStep(driver);
        xistoreStep.doXistoreWrongMail(UserPage.ERROR_EMAIL, UserPage.PASSWORD);
        Assertions.assertEquals(UserPage.TEXT_OF_ERROR_MASSAGE, xistoreStep.getLabelError());
    }

    @Test
    @DisplayName("Проверка входа с корректными данными (электронная почта) и некорректными данными (пароль)")
    public void testXistoreWrongPassword() {
        XistoreStep xistoreStep = new XistoreStep(driver);
        xistoreStep.doXistoreWrongPassword(UserPage.EMAIL, UserPage.ERROR_PASSWORD);
        Assertions.assertEquals(UserPage.TEXT_OF_ERROR_MASSAGE, xistoreStep.getLabelError());
    }

    @Test
    @DisplayName("Проверка входа с некорректными данными (электронная почта и пароль)")
    public void testXistoreWrongMailPassword() {
        XistoreStep xistoreStep = new XistoreStep(driver);
        xistoreStep.doXistoreWrongMailPassword(UserPage.ERROR_EMAIL, UserPage.ERROR_PASSWORD);
        Assertions.assertEquals(UserPage.TEXT_OF_ERROR_MASSAGE, xistoreStep.getLabelError());
    }

    @Test
    @DisplayName("Проверка входа с пустыми полями данных (электронная почта и пароль)")
    public void testXistoreEmptyFieldsMailPassword() {
        XistoreStep xistoreStep = new XistoreStep(driver);
        xistoreStep.doXistoreEmptyFieldsMailPassword(UserPage.EMPTY_EMAIL, UserPage.EMPTY_PASSWORD);
        Assertions.assertEquals(UserPage.TEXT_OF_ERROR_MASSAGE, xistoreStep.getLabelError());
    }

    @Test
    @DisplayName("Проверка наличия и соответствия выбранного товара в профиле (Корзина) ")
    public void testXistoreCart() {
        XistoreStep xistoreStep = new XistoreStep(driver);
        Assertions.assertTrue(xistoreStep.doXistoreCart());
    }

    @Test
    @DisplayName("Поиск товара в поле (Что хотите купить) ")
    public void testProductSearch() {
        WebElement inputNameProduct = driver.findElement(By.xpath(XistorePage.INPUT_NAME_PRODUCT));
        inputNameProduct.sendKeys(UserPage.NAME_PRODUCT_FOR_SEARCH);
        driver.findElement(By.xpath(XistorePage.BTN_SEARCH)).click();
        List<WebElement> listLinkOfPhone = driver.findElements(By.xpath(XistorePage.LIST_LINK_MOBILE_PHONE));
        Assertions.assertFalse(listLinkOfPhone.isEmpty());
        String firstPhone = listLinkOfPhone.get(0).getText();
        Assertions.assertTrue(firstPhone.contains(UserPage.NAME_PRODUCT_FOR_SEARCH));
    }

    @AfterEach
    public void closeDriver() {
        DriverSetup.close();
    }
}
