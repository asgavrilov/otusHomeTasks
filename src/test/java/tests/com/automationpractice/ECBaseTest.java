package tests.com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WebDriverManager;

public class ECBaseTest {

    public WebDriver driver;
    public WebDriverWait webDriverWait;
    int timeout = 10;


    @BeforeClass
    public void beforeTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        driver = WebDriverManager.getDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, timeout);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

// EdgeDriver has a bug while working with MoveToElement - https://github.com/SeleniumHQ/selenium/issues/4605

}

