import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;




public class WebSiteContentValidation {
    String BASE_URL ="http://blazedemo.com/index.php";
    String BUTTON_PATH =  "input.btn.btn-primary";
    String CONTAINER_PATH = "//div[2]/table/tbody/tr/td";

    private static ChromeDriver driver;

    @BeforeClass
    public static void openBrowser() {

        driver = new ChromeDriver();

    }

    @Test
    public void test() {
        driver.get(BASE_URL);
        WebElement button = driver.findElement(By.cssSelector(BUTTON_PATH));
        button.click();
        List<WebElement> content = driver.findElements(By.xpath(CONTAINER_PATH));

        for (WebElement e : content) {
            Assert.assertTrue(e.getText() != "");
            System.out.println(e.getTagName());
            System.out.println(e.getText());

        }
    }


    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

}
