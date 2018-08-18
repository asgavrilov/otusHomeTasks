package tests.plain.TicketsPurchaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class TestInitialization {

    protected static WebDriver driver;
    static int timeOut = 10;
    String baseUrl = "http://blazedemo.com/index.php";
    String buttonPath = "input.btn.btn-primary";
    String containerPath = "//div[2]/table/tbody/tr/td";
    String departureCity = "Boston";
    String arrivalCity = "Berlin";
    String name = "Test Testovich";
    String address = "Sawyer road 41";
    String city = "Waltham";
    String state = "MA";
    String zipcode = "02451";
    String creditCardNumber = "1234456789107777";
    String month = "12";
    String year = "2021";

    protected static WebDriver startDriver(Browsers browserType) {
        switch (browserType) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver");
                return new FirefoxDriver();

            case CHROME:
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
                return new ChromeDriver();

            default:
                return new ChromeDriver();
        }
    }

//    public static WebDriver getDriver() {
//        String driverFromProperties =
//                PropertyReader.getPropertyFromFile("properties/config.properties", "browser");
//        if (driver == null) {
//            switch (driverFromProperties) {
//
//                case "mozilla":
//                    io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    return driver;
//                    //break;
//                case "chrome":
//                    io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    return driver;
//                    //break;
//
//                default:
//                    io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    return driver;
//                   // break;
//            }
//        }
//        return driver;
//    }

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
