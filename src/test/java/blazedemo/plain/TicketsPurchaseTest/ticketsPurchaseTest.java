package blazedemo.plain.TicketsPurchaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ticketsPurchaseTest extends TestInitialization {

    @Test
    public void selectValidation() {
        driver.get(baseUrl);

        WebElement selectFrom = driver.findElement(By.cssSelector("select[name=fromPort]"));
        Select departureCity = new Select(selectFrom);
        departureCity.selectByValue(this.departureCity);

        WebElement selectTo = driver.findElement(By.cssSelector("select[name=toPort]"));
        Select destinationCity = new Select(selectTo);
        destinationCity.selectByValue(arrivalCity);

        WebElement button = driver.findElement(By.cssSelector(buttonPath));
        button.click();


        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]")));

        WebElement label = driver.findElement(By.xpath("//div[2]/h3"));
        Assert.assertEquals("Flights from " + this.departureCity + " to " + arrivalCity + ":", label.getText()); //TODO FIRST CHECK FOR PO

        WebElement departureName = driver.findElement(By.xpath("//div[2]/table/thead/tr/th[4]"));
        WebElement arrivalName = driver.findElement(By.xpath("//div[2]/table/thead/tr/th[5]"));

        Assert.assertEquals("Departs: " + this.departureCity, departureName.getText()); //TODO SECOND CHECK FOR PO
        Assert.assertEquals("Arrives: " + arrivalCity, arrivalName.getText());
    }

    @Test(dependsOnMethods = {"selectValidation"})
    public void chooseAirlineValidation() {
        //Choosing Lufthansa as a Flight Operator

        WebElement price = driver.findElement(By.xpath("//div[2]/table/tbody/tr[5]/td[6]"));
        String tempPrice = price.getText();

        WebElement airlineName = driver.findElement(By.xpath("//div[2]/table/tbody/tr[5]/td[3]"));
        String tempAir = airlineName.getText();

        WebElement flightNo = driver.findElement(By.xpath("//div[2]/table/tbody/tr[5]/td[2]"));
        String tempFlight = flightNo.getText();
        WebElement chooseLufthansa = driver.findElement(By.xpath("//div[2]/table/tbody/tr[5]/td[1]/input"));
        chooseLufthansa.click();

        //adding webdriverwait in case if webpage is loading too long

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]")));
        WebElement p1 = driver.findElement(By.xpath("//div[2]/p[1]"));

        Assert.assertEquals("Airline: " + tempAir, p1.getText());

        WebElement p2 = driver.findElement(By.xpath("//div[2]/p[2]"));
        Assert.assertEquals("Flight Number: " + tempFlight, p2.getText());

        WebElement p3 = driver.findElement(By.xpath("//div[2]/p[3]"));
        Assert.assertEquals("Price: " + tempPrice.substring(1), p3.getText());

        WebElement p4 = driver.findElement(By.xpath("//div[2]/p[4]"));
        String fee = p4.getText().substring(26);

        WebElement p5 = driver.findElement(By.xpath("//div[2]/p[5]"));
        Assert.assertEquals("Total Cost: " + (Double.parseDouble(tempPrice.substring(1))
                + Double.parseDouble(fee)), p5.getText());
    }

    @Test(dependsOnMethods = {"chooseAirlineValidation"})
    public void populateData() {
        WebElement inputName = driver.findElement(By.cssSelector("input[name=inputName]"));
        inputName.sendKeys(name);

        WebElement inputAddress = driver.findElement(By.cssSelector("input[name=address]"));
        inputAddress.sendKeys(address);

        WebElement inputCity = driver.findElement(By.cssSelector("input[name=city]"));
        inputCity.sendKeys(city);

        WebElement inputState = driver.findElement(By.cssSelector("input[name=state]"));
        inputState.sendKeys(state);

        WebElement inputZip = driver.findElement(By.cssSelector("input[name=zipCode]"));
        inputZip.sendKeys(zipcode);

        WebElement inputCreditCard = driver.findElement(By.cssSelector("input[name=creditCardNumber]"));
        inputCreditCard.sendKeys(creditCardNumber);

        WebElement inputNameOnCard = driver.findElement(By.cssSelector("input[name=nameOnCard]"));
        inputNameOnCard.sendKeys(name);

        WebElement creditCardMonth = driver.findElement(By.cssSelector("input[name=creditCardMonth]"));
        creditCardMonth.clear();
        creditCardMonth.sendKeys(month);

        WebElement creditCardYear = driver.findElement(By.cssSelector("input[name=creditCardYear]"));
        creditCardYear.clear();
        creditCardYear.sendKeys(year);

        WebElement purchaseButton = driver.findElement(By.cssSelector("input[type='submit']"));
        purchaseButton.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]")));

        //id
        WebElement id = driver.findElement(By.cssSelector("table[class='table'] tr:nth-child(1) td:nth-child(1)"));
        Assert.assertEquals("Id", id.getText());


        WebElement idValue = driver.findElement(By.cssSelector("table[class='table'] tr:nth-child(1) td:nth-child(1)"));
        Assert.assertTrue(idValue.getText() != "");
        //id

        //status
        WebElement status = driver.findElement(By.cssSelector("table[class='table'] tr:nth-child(2) td:nth-child(1)"));
        Assert.assertEquals("Status", status.getText());

        WebElement statusValue = driver.findElement(By.cssSelector("table[class='table'] tr:nth-child(2) td:nth-child(2)"));
        Assert.assertTrue(statusValue.getText() != "");
        //status

        //amount
        WebElement amount = driver.findElement(By.cssSelector("table[class='table'] tr:nth-child(3) td:nth-child(1)"));
        Assert.assertEquals("Amount", amount.getText());

        WebElement amountValue = driver.findElement(By.cssSelector("table[class='table'] tr:nth-child(3) td:nth-child(2)"));
        Assert.assertTrue(amountValue.getText() != "");
        //amount

        //cardnumber
        WebElement cardNumber = driver.findElement(By.cssSelector("table[class='table'] tr:nth-child(4) td:nth-child(1)"));
        Assert.assertEquals("Card Number", cardNumber.getText());

        WebElement cardNumberValue = driver.findElement(By.cssSelector("table[class='table'] tr:nth-child(4) td:nth-child(2)"));
        Assert.assertEquals(creditCardNumber.substring(12), cardNumberValue.getText().substring(12));
        //cardnumber

        //Expiration
        WebElement expiration = driver.findElement(By.cssSelector("table[class='table'] tr:nth-child(5) td:nth-child(1)"));
        Assert.assertEquals("Expiration", expiration.getText());

        WebElement expirationValue = driver.findElement(By.cssSelector("table[class='table'] tr:nth-child(5) td:nth-child(2)"));
        Assert.assertEquals(month + " /" + year, expirationValue.getText());
        //Expiration

    }

}
