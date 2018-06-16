package tests.com.automationpractice;

import utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ECBaseTest {

    public WebDriver driver;
    public WebDriverWait webDriverWait;
    int timeout = 10;


    @BeforeClass
    public void beforeTest() {
        driver = WebDriverManager.getDriver();
        webDriverWait = new WebDriverWait(driver, timeout);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

// EdgeDriver has a bug while working with MoveToElement - https://github.com/SeleniumHQ/selenium/issues/4605

}

