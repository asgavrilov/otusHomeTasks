package blazedemo.pageObject.TicketsPurchaseTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseFlightPage extends AbstractPage {

    @FindBy(xpath = "//p[1]")
    private WebElement purchaseAirlineElement;
    @FindBy(xpath = "//p[2]")
    private WebElement purchaseAirlineNumberElement;
    @FindBy(xpath = "//p[3]")
    private WebElement purchasePriceElement;
    @FindBy(xpath = "//p[4]")
    private WebElement purchaseFeesTaxesElement;
    @FindBy(xpath = "//p[5]")
    private WebElement purchaseTotalPriceElement;
    @FindBy(css = "input[name=inputName]")
    private WebElement inputName;
    @FindBy(css = "input[name=address]")
    private WebElement inputAddress;
    @FindBy(css = "input[name=city]")
    private WebElement inputCity;
    @FindBy(css = "input[name=state]")
    private WebElement inputState;
    @FindBy(css = "input[name=zipCode]")
    private WebElement zipCode;
    @FindBy(css = "input[name=creditCardNumber]")
    private WebElement creditCardNumber;
    @FindBy(css = "input[name=nameOnCard]")
    private WebElement inputNameOnCard;
    @FindBy(css = "input[name=creditCardMonth]")

    private WebElement creditCardMonth;
    @FindBy(css = "input[name=creditCardYear]")
    private WebElement creditCardYear;
    @FindBy(css = "input[type='submit']")
    private WebElement purchaseButton;

    public PurchaseFlightPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmationPage submitPurchase() {
        purchaseButton.submit();
        return new ConfirmationPage(driver);
    }

    public void setInputName(String inputName) {
        this.inputName.sendKeys(inputName);
    }

    public void setInputAddress(String inputAddress) {
        this.inputAddress.sendKeys(inputAddress);
    }

    public void setInputCity(String inputCity) {
        this.inputCity.sendKeys(inputCity);
    }

    public void setInputState(String inputState) {
        this.inputState.sendKeys(inputState);
    }

    public void setZipCode(String zipCode) {
        this.zipCode.sendKeys(zipCode);
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber.sendKeys(creditCardNumber);
    }

    public void setInputNameOnCard(String inputNameOnCard) {
        this.inputNameOnCard.clear();
        this.inputNameOnCard.sendKeys(inputNameOnCard);
    }

    public void setCreditCardMonth(String creditCardMonth) {
        this.creditCardMonth.clear();
        this.creditCardMonth.sendKeys(creditCardMonth);
    }

    public void setCreditCardYear(String creditCardYear) {
        this.creditCardYear.clear();
        this.creditCardYear.sendKeys(creditCardYear);
    }

    public WebElement getPurchaseAirlineElement() {
        return purchaseAirlineElement;
    }

    public void setPurchaseAirlineElement(WebElement purchaseAirlineElement) {
        this.purchaseAirlineElement = purchaseAirlineElement;
    }

    public WebElement getPurchaseAirlineNumberElement() {
        return purchaseAirlineNumberElement;
    }

    public void setPurchaseAirlineNumberElement(WebElement purchaseAirlineNumberElement) {
        this.purchaseAirlineNumberElement = purchaseAirlineNumberElement;
    }

    public WebElement getPurchasePriceElement() {
        return purchasePriceElement;
    }

    public void setPurchasePriceElement(WebElement purchasePriceElement) {
        this.purchasePriceElement = purchasePriceElement;
    }

    public WebElement getPurchaseTotalPriceElement() {
        return purchaseTotalPriceElement;
    }

    public void setPurchaseTotalPriceElement(WebElement purchaseTotalPriceElement) {
        this.purchaseTotalPriceElement = purchaseTotalPriceElement;
    }

    public WebElement getPurchaseFeesTaxesElement() {
        return purchaseFeesTaxesElement;
    }

    public void setPurchaseFeesTaxesElement(WebElement purchaseFeesTaxesElement) {
        this.purchaseFeesTaxesElement = purchaseFeesTaxesElement;
    }
}

