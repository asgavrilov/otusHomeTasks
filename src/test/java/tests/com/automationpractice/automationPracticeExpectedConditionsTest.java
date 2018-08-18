package tests.com.automationpractice;

import com.automationpractice.indexPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.pageObject.BaseTest;

public class automationPracticeExpectedConditionsTest extends BaseTest {

    private static final String URL = "http://automationpractice.com/index.php";

    @Description("Automationpractice.com test")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Automationpractice.com test")
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
