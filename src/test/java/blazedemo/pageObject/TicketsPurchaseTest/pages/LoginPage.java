package blazedemo.pageObject.TicketsPurchaseTest.pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(css = "div.panel-heading")
    @Setter
    @Getter
    private WebElement loginHeader;

    @FindBy(xpath = "//*[@type='submit']")
    @Getter
    @Setter
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='email']")
    @Getter
    @Setter
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='password']")
    @Getter
    @Setter
    private WebElement passInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String emailValue) {

        emailInput.sendKeys(emailValue);
    }

    public void setPassInput(String passValue) {
        passInput.sendKeys(passValue);
    }

    public void submit() {
        loginButton.submit();
    }

    public void mouseOver(WebElement loginPage) {
        Actions actions = new Actions(driver);
        actions.moveToElement(loginPage);
        actions.perform();
    }
}
