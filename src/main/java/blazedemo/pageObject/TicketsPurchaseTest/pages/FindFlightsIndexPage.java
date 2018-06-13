package blazedemo.pageObject.TicketsPurchaseTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FindFlightsIndexPage extends AbstractPage {

    @FindBy(css = "input[type=submit]")
    WebElement chooseSubmitButton;
    private WebDriver driver;
    @FindBy(css = "select[name=fromPort]")
    private WebElement selectFromElement;
    @FindBy(css = "select[name=toPort]")
    private WebElement selectToElement;

    public FindFlightsIndexPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSelectFromElement() {
        return selectFromElement;
    }

    public void setSelectFromElement(WebElement selectFromElement) {
        this.selectFromElement = selectFromElement;
    }

    public WebElement getSelectToElement() {
        return selectToElement;
    }

    public void setSelectToElement(WebElement selectToElement) {
        this.selectToElement = selectToElement;
    }

    public void selectFrom(String fromCity) {
        new Select(selectFromElement).selectByValue(fromCity);

    }

    public void selectTo(String toCity) {
        new Select(selectToElement).selectByValue(toCity);

    }


    public ReserveFlightPage submit() {
        chooseSubmitButton.click();
        return new ReserveFlightPage(driver);
    }

}
