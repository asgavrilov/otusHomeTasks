package blazedemo.pageObject.TicketsPurchaseTest.tests;

import blazedemo.pageObject.TicketsPurchaseTest.pages.LoginPage;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {
    public static final String LOGIN_URL = "http://blazedemo.com/login";
    String expectedColor = "rgba(37, 121, 169, 1)";
    String email = "any@email.com";
    String pwd = "anypwd";

    @Test(suiteName = "FunctionalTest")
    public void LoginPageTest() {
        driver.get(LOGIN_URL);
        LoginPage lp = new LoginPage(driver);
        lp.setEmail(email);
        lp.setPassInput(pwd);
        Dimension initialSize = lp.getLoginButton().getSize();
        System.out.println("Size before mouseOver action is:" + initialSize);
        lp.mouseOver(lp.getLoginButton());
        Dimension mouseOverSize = lp.getLoginButton().getSize();
        System.out.println("Size before mouseOver action is:" + mouseOverSize);
        Assert.assertEquals(initialSize, mouseOverSize, "Size is the same");
        Assert.assertEquals(expectedColor, lp.getLoginButton().getCssValue("background-color"));
        System.out.println("Expected button color: rgba(37, 121, 169, 1). Actual button color: "
                + lp.getLoginButton()
                .getCssValue("background-color"));
        lp.getLoginButton().submit();
        Assert.assertTrue(lp.getLoginHeader().isDisplayed());

    }
}
