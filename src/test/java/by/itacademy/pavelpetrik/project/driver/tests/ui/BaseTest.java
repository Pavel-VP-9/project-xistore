package by.itacademy.pavelpetrik.project.driver.tests.ui;

import by.itacademy.pavelpetrik.project.driver.driver.DriverSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import by.itacademy.pavelpetrik.project.driver.pages.XistorePage;

public class BaseTest {
    WebDriver driver = DriverSetup.getDriver();

    @BeforeEach
    public void beforeTestActions() {
        driver.get(XistorePage.URL);
    }
    @AfterEach
    public void afterTestActions() {
        DriverSetup.close();
    }
}
