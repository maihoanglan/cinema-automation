package page.customers_management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomersManagementPage {
    WebDriver driver;
    By titleOfPageSelector = By.className("card-title");
    By viewBookingsHyperlinkSelector = By.xpath("//tbody/tr/td[7]/a");
    By customerNameSelector = By.xpath("//tbody/tr/td");
    By editIconSelector = By.xpath("//a[@title='Edit Customer']");
    By customerAddressSelector = By.xpath("//tbody/tr/td[6]");
    By searchBoxSelector = By.id("searchValue");
    By searchButtonSelector = By.xpath("//div[@id='order-listing_filter']//button");
    By customerEmailSelector = By.xpath("//tbody/tr/td[2]");
    By textMessageSelector = By.xpath("//tbody//div//h5");

    public CustomersManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleCustomersManagementPage() {
        return driver.findElement(titleOfPageSelector).getText();
    }

    public void openViewBookingsOfCustomerPage() {
        driver.findElement(viewBookingsHyperlinkSelector).click();
    }

    public String getCustomerNameInCustomersManagementPage() {
        return driver.findElement(customerNameSelector).getText();
    }

    public void openUpdateCustomerAddressPage() {
        driver.findElement(editIconSelector).click();
    }

    public String getCustomerAddress() {
        return driver.findElement(customerAddressSelector).getText();
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButtonSelector).click();
    }

    public boolean search(String keySearch) {
        WebElement searchBox = driver.findElement(searchBoxSelector);
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(keySearch);
        clickOnSearchButton();

        // Verify search results
        List<WebElement> resultMovies = driver.findElements(customerEmailSelector);

        boolean foundExactMatch = false;
        for (WebElement result : resultMovies) {
            if (result.getText().contains(keySearch)) {
                foundExactMatch = true;
                break;
            }
        }
        return foundExactMatch;
    }

    public String searchForNoResult(String keySearch) {
        WebElement searchExactly = driver.findElement(searchBoxSelector);
        searchExactly.click();
        searchExactly.clear();
        searchExactly.sendKeys(keySearch);
        clickOnSearchButton();

        return driver.findElement(textMessageSelector).getText();
    }
}
