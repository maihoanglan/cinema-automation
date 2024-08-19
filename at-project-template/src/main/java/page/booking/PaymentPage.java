package page.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    WebDriver driver;
    By cardNumberSelector = By.id("cardNumber");
    By cardNameSelector = By.id("cardName");
    By yearExpiryDate = By.id("yearExpiryDate");
    By monthExpiryDate = By.id("monthExpiryDate");
    By cvvCode = By.id("cvvCode");
    By continueButtonSelector = By.xpath("//div[@class='col-5 ticketInfo']//button[@onclick]");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputCardNumber(String cardNumber) {
        driver.findElement(cardNumberSelector).click();
        driver.findElement(cardNumberSelector).sendKeys(cardNumber);
    }

    public void inputCardName(String cardName) {
        driver.findElement(cardNameSelector).click();
        driver.findElement(cardNameSelector).sendKeys(cardName);
    }

    public void monthYearExpiryDate(String year) {
        driver.findElement(monthExpiryDate).click();
        driver.findElement(monthExpiryDate).clear();
        driver.findElement(monthExpiryDate).sendKeys(year);
    }

    public void inputYearExpiryDate(String year) {
        driver.findElement(yearExpiryDate).click();
        driver.findElement(yearExpiryDate).clear();
        driver.findElement(yearExpiryDate).sendKeys(year);
    }

    public void inputCvvCode(String code) {
        driver.findElement(cvvCode).click();
        driver.findElement(cvvCode).sendKeys(code);
    }

    public void clickContinueButtonSeatSelection() {
        driver.findElement(continueButtonSelector).click();
    }

    public void payment(String cardNumber, String cardName, String month, String year, String code) {
        inputCardNumber(cardNumber);
        inputCardName(cardName);
        monthYearExpiryDate(month);
        inputYearExpiryDate(year);
        inputCvvCode(code);
        clickContinueButtonSeatSelection();
    }
}
