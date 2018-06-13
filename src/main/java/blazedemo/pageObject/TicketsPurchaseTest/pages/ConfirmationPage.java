package blazedemo.pageObject.TicketsPurchaseTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ConfirmationPage extends AbstractPage {
    private WebDriver driver;

    @FindBy(css = "table[class='table'] tr:nth-child(1) td:nth-child(1)")
    private WebElement id;
    @FindBy(css = "table[class='table'] tr:nth-child(1) td:nth-child(1)")
    private WebElement idValue;
    @FindBy(css = "table[class='table'] tr:nth-child(2) td:nth-child(1)")
    private WebElement status;
    @FindBy(css = "table[class='table'] tr:nth-child(2) td:nth-child(2)")
    private WebElement statusValue;
    @FindBy(css = "table[class='table'] tr:nth-child(3) td:nth-child(1)")
    private WebElement amount;
    @FindBy(css = "table[class='table'] tr:nth-child(3) td:nth-child(2)")
    private WebElement amountValue;
    @FindBy(css = "table[class='table'] tr:nth-child(4) td:nth-child(1)")
    private WebElement cardNumber;
    @FindBy(css = "table[class='table'] tr:nth-child(4) td:nth-child(2)")
    private WebElement cardNumberValue;
    @FindBy(css = "table[class='table'] tr:nth-child(5) td:nth-child(1)")
    private WebElement expiration;
    @FindBy(css = "table[class='table'] tr:nth-child(5) td:nth-child(2)")
    private WebElement expirationValue;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getId() {
        return id;
    }

    public WebElement getIdValue() {
        return idValue;
    }

    public WebElement getStatus() {
        return status;
    }

    public WebElement getStatusValue() {
        return statusValue;
    }

    public WebElement getAmount() {
        return amount;
    }

    public WebElement getAmountValue() {
        return amountValue;
    }

    public WebElement getCardNumber() {
        return cardNumber;
    }

    public WebElement getCardNumberValue() {
        return cardNumberValue;
    }

    public WebElement getExpiration() {
        return expiration;
    }

    public WebElement getExpirationValue() {
        return expirationValue;
    }
}
