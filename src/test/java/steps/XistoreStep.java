package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.XistorePage;

public class XistoreStep {
    WebDriver driver;

    public XistoreStep(WebDriver driver) {
        this.driver = driver;

    }
    public boolean doXistoreLogin() {

        driver.findElement(By.xpath(XistorePage.BTN_ENTER)).click();
        WebElement inputMail = driver.findElement(By.xpath(XistorePage.INPUT_MAIL));
        inputMail.sendKeys("ppp694185@gmail.com");
        WebElement inputPassword = driver.findElement(By.xpath(XistorePage.INPUT_PASSWORD));
        inputPassword.sendKeys("10293847ppp");
        driver.findElement(By.xpath(XistorePage.BTN_INTER_SUBMIT)).click();
        driver.findElement(By.xpath(XistorePage.BTN_CHECK_REGISTRATION)).click();
        String labelName = driver.findElement(By.xpath(XistorePage.LINK_MAIL)).getText();
        System.out.println(labelName);
        System.out.println("ppp694185@gmail.com");
        return labelName.equals("ppp694185@gmail.com");

    }
}
