package pages;

import driver.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Util;

public class LoginPage {
    WebDriver driver  = DriverSetup.getDriver();

    public void openLoginForm() {
         driver.findElement(By.xpath(XistorePage.BTN_ENTER)).click();
    }
    public void inputEmail(String email) {
        driver.findElement(By.xpath(XistorePage.INPUT_MAIL)).sendKeys(email);
    }
    public void inputPassword(String password) {
        driver.findElement(By.xpath(XistorePage.INPUT_PASSWORD)).sendKeys(password);
    }
    public void interSubmit() {
        driver.findElement(By.xpath(XistorePage.BTN_INTER_SUBMIT)).click();
    }
    public void checkRegistrashion(){
        driver.findElement(By.xpath(XistorePage.BTN_CHECK_REGISTRATION)).click();
        Util.waitTimeFor(3);
    }

//    public String checkRegistrashion() {
//
//       // String labelName = driver.findElement(By.xpath(XistorePage.LINK_MAIL)).getText();
//       // return labelName;
//        return driver.findElement(By.xpath(XistorePage.LINK_MAIL)).getText(); }

    public String getUserName() {

        return driver.findElement(By.xpath(XistorePage.LINK_MAIL)).getText();

    }
}
