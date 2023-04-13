package pages;

import driver.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static final String BTN_ENTER = "//a[@class='navigation-cabinet-link']";
    public static final String INPUT_MAIL = "//input[@name='USER_LOGIN']";
    public static final String INPUT_PASSWORD = "//input[@type='password']";
    public static final String BTN_INTER_SUBMIT = "//input[@value='ВОЙТИ']";
   // public static final String BTN_CHECK_REGISTRATION = "/html/body/div[2]/div[1]/div/div/div/nav[3]/ul";
    // public static final String BTN_CHECK_REGISTRATION = "//a[@data-toggle='dropdown'][@aria-expanded='true']";
    public static final String BTN_CHECK_REGISTRATION = "//li//a[@data-toggle='dropdown'][@href='#']";
    public static final String LINK_MAIL = "//span[@href='/personal/']";
    public static final String LOGIN_WRONG_MAIL = "(//p//font[@class='errortext'])[1]";

    WebDriver driver = DriverSetup.getDriver();

    public void openLoginForm() {
        driver.findElement(By.xpath(BTN_ENTER)).click();
    }

    public void inputEmail(String email) {
        driver.findElement(By.xpath(INPUT_MAIL)).sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(password);
    }

    public void interSubmit() {
        driver.findElement(By.xpath(BTN_INTER_SUBMIT)).click();
    }

    public void checkRegistrashion() {
        driver.findElement(By.xpath(BTN_CHECK_REGISTRATION)).click();
    }

    public String getUserName() {
        return driver.findElement(By.xpath(LINK_MAIL)).getText();
    }

    public String getLabelError() {
        return driver.findElement(By.xpath(LOGIN_WRONG_MAIL)).getText();
    }

    public void refreshPage() {
        DriverSetup.getDriver().navigate().refresh();
    }
}
