package page.customer_credit_card;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DepositForCustomerCreditCardPage {
    WebDriver driver;
    By depositBalanceSelector = By.id("formatBalance");
    By depositButtonSelector = By.xpath("//form[@id='command']//button");
    By transactionCompleteTextSelector = By.xpath("//h5[text()='Transaction Complete']");
    By amountDepositSelector = By.xpath("//label[text()='Deposit Balance: ']/following-sibling::input");
    By transactionDateSelector = By.xpath("//label[text()='Transaction Date: ']/following-sibling::input");
    By errorMessageOfDepositBalanceSelector = By.xpath("//p[@class='card-description']");

    public DepositForCustomerCreditCardPage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickOnDepositBalance() {
        driver.findElement(depositBalanceSelector).click();
    }

    private void sendKeysForDepositBalance(int amount) {
        driver.findElement(depositBalanceSelector).sendKeys(String.valueOf(amount));
    }

    public void clickOnDepositButton() {
        driver.findElement(depositButtonSelector).click();
    }

    public boolean isTransactionCompleteTextDisplayed() {
        return driver.findElement(transactionCompleteTextSelector).isDisplayed();
    }

    public String getDepositBalance() {
        WebElement ownerName = driver.findElement(amountDepositSelector);
        return ownerName.getAttribute("value");
    }

    public String getErrorMessageOfDepositBalance() {
        return driver.findElement(errorMessageOfDepositBalanceSelector).getText();
    }

    public int getDefaultValueOfDepositBalance() {
        WebElement depositAmount = driver.findElement(depositBalanceSelector);
        int defaultValue = Integer.parseInt(depositAmount.getAttribute("value"));
        return defaultValue;
    }

    public String getTransactionDate() {
        WebElement dateTimeTransaction = driver.findElement(transactionDateSelector);
        String date = dateTimeTransaction.getAttribute("value");

        // Define the input and output date-time formatters
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Parse the input string to LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(date, inputFormatter);

        // Set seconds to 00
        dateTime = dateTime.withSecond(0).withNano(0);

        // Format the LocalDateTime to the desired output string
        String result = dateTime.format(outputFormatter);

        return result;
    }

    public void sendMoney(int amount) {
        clickOnDepositBalance();
        sendKeysForDepositBalance(amount);
        clickOnDepositButton();
    }
}
