package com.automationpractice;

import blazedemo.pageObject.TicketsPurchaseTest.pages.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class indexPage extends AbstractPage {
    private int timeout = 10;
    @FindBy(css = "ul.submenu-container")

    private WebElement subMenuContainer;
    @FindBy(css = "a[title='T-shirts']")
    private WebElement tshirtItem;

    @FindBy(css = "a[title='Women']")
    private WebElement womenContainerMenuItem;

    @FindBy(css = "div.product-container")
    @Getter
    private WebElement resultsContainerItem;
    @FindBy(css = "ul.product_list")
    @Getter
    private WebElement resultsContainer;
    private String resContainerElement = "ul.product_list";

    public indexPage(WebDriver driver) {
        super(driver);
    }

    public void mouseOverWomen() {
        Actions actions = new Actions(driver);
        actions.moveToElement(womenContainerMenuItem).build().perform();


    }

    public void tshirtMenuItemToClick() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        webDriverWait.until(ExpectedConditions.visibilityOf(subMenuContainer));
        tshirtItem.click();
    }

    public int validateResults() {
        List<WebElement> webElements = driver.findElements(By.cssSelector(resContainerElement));
        int size = webElements.size();
        System.out.println(size);
        return size;
    }
}