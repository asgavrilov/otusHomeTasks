package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver(ChromeOptions chromeOptions) {
        String driverFromProperties =
                PropertyReader.getPropertyFromFile("properties/config.properties", "browser");
        if (driver == null) {
            switch (driverFromProperties) {

                case "mozilla":
                    createFirefoxDriver();
                    break;
                case "ie":
                    createIEDriver();
                    break;
                case "chrome":
                    createChromeDriver(false);
                    break;
                case "chrome-headless":
                    createChromeDriver(true);
                    break;
                default:
                    createChromeDriver(false);
                    break;
            }
        }
        return driver;
    }

    private static WebDriver createChromeDriver(Boolean headless) {
        if (headless) {
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else {
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }


    private static WebDriver createFirefoxDriver() {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    private static WebDriver createIEDriver() {
        io.github.bonigarcia.wdm.WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        return driver;
    }
}
