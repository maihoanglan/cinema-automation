package page.transactions_cinema;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TransactionsCinemaPage {
    WebDriver driver;
    By transactionDateSelector = By.xpath("//tbody/tr/td");
    By amountSelector = By.xpath("//tbody/tr/td[3]");
    By customerNameSelector = By.xpath("//tbody/tr/td[4]/p");
    By titleOfPageSelector = By.className("card-title");
    By transactionsNumberDropdownSelector = By.id("size");
    By numberOfTransactionsSelector = By.xpath("//tbody//tr");
    By customerEmailSelector = By.xpath("//tbody/tr/td[4]/p[2]");
    By searchBoxSelector = By.id("searchValue");
    By searchButtonSelector = By.xpath("//div[@id='order-listing_filter']//button");
    By textMessageSelector = By.xpath("//tbody//div//h5");

    public TransactionsCinemaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(titleOfPageSelector).getText();
    }

    public String getTransactionTime() {
        WebElement dateTimeTransaction = driver.findElement(transactionDateSelector);
        String date = dateTimeTransaction.getText();

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

    public String getAmountDeposit() {
        return driver.findElement(amountSelector).getText();
    }

    public String getCustomerName() {
        return driver.findElement(customerNameSelector).getText();
    }

    private void selectNumberOfTransactions(String rows) {
        WebElement transactionsNumber = driver.findElement(transactionsNumberDropdownSelector);
        transactionsNumber.click();
        Select select = new Select(transactionsNumber);
        select.selectByVisibleText(rows);
    }

    public void showFiveTransactionRows() {
        selectNumberOfTransactions("5");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElements(numberOfTransactionsSelector).size() == 5);
    }

    public void showTenTransactionRows() {
        selectNumberOfTransactions("10");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElements(numberOfTransactionsSelector).size() == 10);
    }

    public void showFifteenTransactionRows() {
        selectNumberOfTransactions("15");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElements(numberOfTransactionsSelector).size() == 15);
    }

    public int numberOfTransactionsIsDisplay() {
        List<WebElement> numberOfTransactions = driver.findElements(numberOfTransactionsSelector);
        int rowTransactions;
        return rowTransactions = numberOfTransactions.size();
    }

    public String getEmailOfFirstRow() {
        return driver.findElement(customerEmailSelector).getText();
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButtonSelector).click();
    }

    public boolean areAllEmailContains(String email) {
        List<WebElement> resultCustomer = driver.findElements(customerEmailSelector);
        boolean foundExactMatch = false;
        for (WebElement result : resultCustomer) {
            if (result.getText().contains(email)) {
                foundExactMatch = true;
                break;
            }
        }
        return foundExactMatch;
    }

    public boolean isNoResultDisplayed() {
        return driver.findElement(textMessageSelector).isDisplayed();
    }

    public void search(String email) {
        WebElement searchBox = driver.findElement(searchBoxSelector);
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(email);
        clickOnSearchButton();
    }
}
