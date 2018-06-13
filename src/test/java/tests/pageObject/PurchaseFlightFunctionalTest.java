package tests.pageObject;


import blazedemo.pageObject.TicketsPurchaseTest.pages.ConfirmationPage;
import blazedemo.pageObject.TicketsPurchaseTest.pages.FindFlightsIndexPage;
import blazedemo.pageObject.TicketsPurchaseTest.pages.PurchaseFlightPage;
import blazedemo.pageObject.TicketsPurchaseTest.pages.ReserveFlightPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseFlightFunctionalTest extends BaseTest {
    String tempAirline;
    String tempFlightNo;
    String tempPrice;
    private String departureCity = "Boston";
    private String arrivalCity = "Berlin";
    private String name = "Test Testovich";
    private String address = "Sawyer road 41";
    private String city = "Waltham";
    private String state = "MA";
    private String zipcode = "02451";
    private String creditCardNumber = "1234456789107777";
    private String month = "12";
    private String year = "2021";

    @Test(suiteName = "FunctionalTest")
    public void FindFlightIndexTest() {


        FindFlightsIndexPage flightsPage = new FindFlightsIndexPage(driver);
        flightsPage.selectFrom(departureCity);
        flightsPage.selectTo(arrivalCity);
        flightsPage.submit();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]")));
    }

    @Test(suiteName = "FunctionalTest", dependsOnMethods = "FindFlightIndexTest")
    public void ReserveFlightTest() {
        ReserveFlightPage ReserveFlightPage = new ReserveFlightPage(driver);
        Assert.assertEquals("Flights from " + departureCity + " to " + arrivalCity + ":",
                ReserveFlightPage.getHeaderElement().getText());

        Assert.assertEquals("Departs: " + departureCity, ReserveFlightPage.getDepartureNameField().getText());
        Assert.assertEquals("Arrives: " + arrivalCity, ReserveFlightPage.getArrivalNameField().getText());
        tempAirline = ReserveFlightPage.getAirlineElement().getText();
        tempFlightNo = ReserveFlightPage.getReservedflightNo().getText();
        tempPrice = ReserveFlightPage.getReservePriceElement().getText();
        ReserveFlightPage.submitLufthansa();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]")));
    }

    @Test(suiteName = "FunctionalTest", dependsOnMethods = "ReserveFlightTest")
    public void PurchaseFlightTest() {

        PurchaseFlightPage purchaseFlightPage = new PurchaseFlightPage(driver);
        Assert.assertEquals("Airline: " + tempAirline, purchaseFlightPage.
                getPurchaseAirlineElement().getText());
        Assert.assertEquals("Flight Number: " + tempFlightNo, purchaseFlightPage.
                getPurchaseAirlineNumberElement().getText());
        Assert.assertEquals("Price: " + tempPrice.substring(1), purchaseFlightPage.
                getPurchasePriceElement().getText());
        String fee = purchaseFlightPage.getPurchaseFeesTaxesElement().getText().substring(26);
        Assert.assertEquals("Total Cost: " + (Double.parseDouble(tempPrice.substring(1)) +
                Double.parseDouble(fee)), purchaseFlightPage.
                getPurchaseTotalPriceElement().getText());

        purchaseFlightPage.setInputName(name);
        purchaseFlightPage.setInputAddress(address);
        purchaseFlightPage.setInputCity(city);
        purchaseFlightPage.setInputState(state);
        purchaseFlightPage.setZipCode(zipcode);
        purchaseFlightPage.setCreditCardNumber(creditCardNumber);
        purchaseFlightPage.setCreditCardMonth(month);
        purchaseFlightPage.setCreditCardYear(year);
        purchaseFlightPage.setInputNameOnCard(name);
        purchaseFlightPage.submitPurchase();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]")));

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        Assert.assertEquals("Id", confirmationPage.getId().getText());
        Assert.assertTrue(confirmationPage.getIdValue().getText() != "");
        Assert.assertEquals("Status", confirmationPage.getStatus().getText());
        Assert.assertTrue(confirmationPage.getStatusValue().getText() != "");
        Assert.assertEquals("Amount", confirmationPage.getAmount().getText());
        Assert.assertTrue(confirmationPage.getAmount().getText() != "");
        Assert.assertEquals("Card Number", confirmationPage.getCardNumber().getText());
        Assert.assertEquals(creditCardNumber.substring(12), confirmationPage.getCardNumberValue().getText().substring(12));
        Assert.assertEquals("Expiration", confirmationPage.getExpiration().getText());
        Assert.assertEquals(month + " /" + year, confirmationPage.getExpirationValue().getText());
    }

}

