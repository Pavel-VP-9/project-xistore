package pages;

import driver.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver = DriverSetup.getDriver();

    public void inputSearchProduct() {
        driver.findElement(By.xpath(XistorePage.BTN_CATALOG_PHONE)).click();
        driver.findElement(By.xpath(XistorePage.SELECTION_PHONE)).click();
    }

    public String getNameFirstProduct() {
        String[] title = driver.findElement(By.xpath(XistorePage.NAME_PHONE)).getText().split("\n");
        String namePhone = title[0];
        return namePhone;
        // System.out.println(namePhone);
    }
    public void inputSearchProductInCart() {
        driver.findElement(By.xpath(XistorePage.BTN_PLACE_AN_ORDER_CART)).click();
        driver.findElement(By.xpath(XistorePage.BTN_CLOSE)).click();
        driver.findElement(By.xpath(XistorePage.BTN_INPUT_CART)).click();
    }

    public String putNameFirstProduct() {
        String namePhoneInCart = driver.findElement(By.xpath(XistorePage.NAME_PHONE_IN_CART)).getText();
        return namePhoneInCart;
        // System.out.println(namePhoneInCart);
        //return namePhoneInCart.contains(namePhone);
        // Assertions.assertTrue(namePhoneInCart.contains(namePhone));
    }
}
