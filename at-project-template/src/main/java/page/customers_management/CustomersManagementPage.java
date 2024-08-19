package page.customers_management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomersManagementPage {
    WebDriver driver;
    String result;
    By titleOfPageSelector = By.className("card-title");
    By viewBookingsHyperlinkSelector = By.xpath("//tbody/tr/td[7]/a");
    By customerNameSelector = By.xpath("//tbody/tr/td");
//    By editIconSelector = By.xpath(String.format("//tr[%s]//a[@title='Edit Customer']"));
//    By customerAddressSelector = By.xpath("//tbody/tr[%s]/td[6]");
    By searchBoxSelector = By.id("searchValue");
    By searchButtonSelector = By.xpath("//div[@id='order-listing_filter']//button");
    By customerEmailSelector = By.xpath("//tbody/tr/td[2]");
    By textMessageSelector = By.xpath("//tbody//div//h5");

    public CustomersManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(titleOfPageSelector).getText();
    }

    public void openViewBookingsOfCustomerPage() {
        driver.findElement(viewBookingsHyperlinkSelector).click();
    }

    public String getCustomerNameInCustomersManagementPage() {
        return driver.findElement(customerNameSelector).getText();
    }

    public void openUpdateCustomerAddressPage(int row) {
        driver.findElement(By.xpath(String.format("//tr[%s]//a[@title='Edit Customer']", row))).click();
    }

    public String getCustomerAddress(int row) {
        return driver.findElement(By.xpath(String.format("//tbody/tr[%s]/td[6]", row))).getText();
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButtonSelector).click();
    }

    private void search(String email) {
        WebElement searchBox = driver.findElement(searchBoxSelector);
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(email);
        clickOnSearchButton();
    }

    public String getExactlyEmailExistsInDB() {
        return driver.findElement(customerEmailSelector).getText();
    }

    public String getPartiallyEmailExistsInDB() {
        String partiallyOfMovieName = driver.findElement(customerEmailSelector).getText();
        if (partiallyOfMovieName.length() > 3) {
            result = partiallyOfMovieName.substring(0, 3);
        } else {
            result = driver.findElement(customerEmailSelector).getText();
        }
        return result;
    }

    public boolean searchEmailHasResult(String email) {
        search(email);

        // Verify search results
        List<WebElement> resultMovies = driver.findElements(customerEmailSelector);

        boolean foundExactMatch = false;
        for (WebElement result : resultMovies) {
            if (result.getText().contains(email)) {
                foundExactMatch = true;
                break;
            }
        }
        return foundExactMatch;
    }

    public String searchEmailNoResult(String email) {
        search(email);
        return driver.findElement(textMessageSelector).getText();
    }
}
