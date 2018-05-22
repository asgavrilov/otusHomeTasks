package blazedemo.pageObject.TicketsPurchaseTest.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReserveFlightPage extends AbstractPage {


    private WebDriver driver;

    @FindBy(tagName = "h3")
    private WebElement headerElement;

    @FindBy(xpath = "//div[2]/table/thead/tr/th[4]")
    private WebElement departureNameField;

    @FindBy(xpath = "//div[2]/table/thead/tr/th[5]")
    private WebElement arrivalNameField;

    @FindBy(xpath = "//div[2]/table/tbody/tr[5]/td[6]")
    private WebElement reservePriceElement;

    @FindBy(xpath = "//div[2]/table/tbody/tr[5]/td[3]")
    private WebElement airlineElement;

    @FindBy(xpath = "//div[2]/table/tbody/tr[5]/td[2]")
    private WebElement reservedflightNo;

    @FindBy(xpath = "//div[2]/table/tbody/tr[5]/td[1]/input")
    private WebElement chooseLufthansaSubmitButton;

    public ReserveFlightPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeaderElement() {
        return headerElement;
    }

    public WebElement getReservePriceElement() {
        return reservePriceElement;
    }

    public WebElement getAirlineElement() {
        return airlineElement;
    }

    public WebElement getReservedflightNo() {
        return reservedflightNo;
    }

    public WebElement getDepartureNameField() {
        return departureNameField;
    }

    public void setDepartureNameField(WebElement departureNameField) {
        this.departureNameField = departureNameField;
    }

    public WebElement getArrivalNameField() {
        return arrivalNameField;
    }

    public PurchaseFlightPage submitLufthansa() {
        chooseLufthansaSubmitButton.click();
        return new PurchaseFlightPage(driver);
    }


}