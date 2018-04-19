package TicketsPurchase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class TestInitialization {

    protected static WebDriver driver;
    static int timeOut = 10;
    String BASE_URL = "http://blazedemo.com/index.php";
    String BUTTON_PATH = "input.btn.btn-primary";
    String CONTAINER_PATH = "//div[2]/table/tbody/tr/td";
    String DEPARTURE_CITY = "Boston";
    String ARRIVAL_CITY = "Berlin";
    String NAME = "Test Testovich";
    String ADDRESS = "Sawyer road 41";
    String CITY = "Waltham";
    String STATE = "MA";
    String ZIPCODE = "02451";
    String CreditCardNumber = "1234456789107777";
    String MONTH = "12";
    String YEAR = "2021";

    protected static WebDriver startDriver(Browsers browserType) {
        switch (browserType) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "/home/alexander/IdeaProjects/OtusTasks/geckodriver");
                return new FirefoxDriver();

            case CHROME:
                System.setProperty("webdriver.chrome.driver", "/home/alexander/IdeaProjects/OtusTasks/chromedriver");
                return new ChromeDriver();

            default:
                return new ChromeDriver();
        }
    }

    @BeforeClass
    public static void openBrowser() {

        driver = startDriver(Browsers.CHROME);
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void closeBrowser() {

        driver.quit();
    }

    public enum Browsers {
        CHROME, FIREFOX;
    }
}
