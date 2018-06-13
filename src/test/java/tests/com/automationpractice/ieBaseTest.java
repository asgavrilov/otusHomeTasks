package tests.com.automationpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class ieBaseTest {
    private static final String URL = "http://automationpractice.com/index.php";
    public static WebDriver driver;
    static WebDriverWait webDriverWait;
    static int timeout = 10;

    @BeforeClass
    public void setupClass() {

//EdgeDriver has a bug while working with MoveToElement - https://github.com/SeleniumHQ/selenium/issues/4605
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, timeout);
        driver.get(URL);

    }

    @AfterClass
    public void afterClass() {

        if (driver != null) {
            driver.quit();
        }

    }
}