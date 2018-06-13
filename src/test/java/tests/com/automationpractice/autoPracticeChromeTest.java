package tests.com.automationpractice;

import com.automationpractice.indexPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.pageObject.BaseTest;

public class autoPracticeChromeTest extends BaseTest {

    private static final String URL = "http://automationpractice.com/index.php";


    @Test
    public void autoPracticeChromeTest() {
        driver.get(URL);
        indexPage indexPage = new indexPage(driver);
        indexPage.mouseOverWomen();
        indexPage.tshirtMenuItemToClick();
        Assert.assertTrue(indexPage.getResultsContainer().isDisplayed());
        Assert.assertTrue(indexPage.getResultsContainerItem().isDisplayed());
        Assert.assertTrue(indexPage.validateResults() != 0);
    }
}
