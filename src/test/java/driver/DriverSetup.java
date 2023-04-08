package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.XistorePage;

import java.time.Duration;

public class DriverSetup {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("start-maximized");
            driver = new ChromeDriver(chromeOptions);
            //driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           // ??? надо ставить если нет их driver.manage().deleteAllCookies();
           // driver.get(XistorePage.URL);
        }
        return driver;
    }
    public static void close(){
        if (driver!= null) {
            driver.quit();
           // driver = null;
        }
    }
}
