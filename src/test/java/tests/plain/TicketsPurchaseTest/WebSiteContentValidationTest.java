package tests.plain.TicketsPurchaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class WebSiteContentValidationTest extends TestInitialization {


    @Test(testName = "Content Validation")
    public void test() {
        driver.get(baseUrl);
        WebElement button = driver.findElement(By.cssSelector(buttonPath));
        button.click();
        List<WebElement> content = driver.findElements(By.xpath(containerPath));

        for (WebElement e : content) {
            Assert.assertTrue(e.getText() != "");
            System.out.println(e.getTagName());
            System.out.println(e.getText());

        }
    }


}
