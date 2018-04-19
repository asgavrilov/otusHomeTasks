package TicketsPurchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class WebSiteContentValidation extends TestInitialization {


    @Test(testName = "Content Validation")
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


}
