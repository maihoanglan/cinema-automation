package page.customers_management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ViewBookingsOfCustomer {
    WebDriver driver;
    String title;
    String name;
    By titleViewBookingsOfCustomerSelector = By.xpath("//div[@class='card-body']/h4");
    By backToListCustomersSelector = By.xpath("//div[@class='row']//a[@href='/DoubleTCinema/admin/customers']");

    public ViewBookingsOfCustomer(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        String titleViewBookingsOfCustomer = driver.findElement(titleViewBookingsOfCustomerSelector).getText();

        // Find the index where ':' starts
        int endIndex = titleViewBookingsOfCustomer.indexOf(":");

        if (endIndex != -1) {
            // Extract the substring from the beginning up to endIndex
            title = titleViewBookingsOfCustomer.substring(0, endIndex); // 'View Bookings Of Customer'
        }
        return title;
    }

    public String getCustomerName() {
        String nameOfCustomer = driver.findElement(titleViewBookingsOfCustomerSelector).getText();

        // Find the index where ':' starts
        int colonIndex = nameOfCustomer.indexOf(":");

        if (colonIndex != -1) {
            // Extract the substring after the colon and trim any leading spaces
            name = nameOfCustomer.substring(colonIndex + 1).trim();
        }
        return name;
    }

    private void clickOnBackToListCustomers() {
        WebElement backButton = driver.findElement(backToListCustomersSelector);
        Actions actions = new Actions(driver);
        actions.moveToElement(backButton);
        actions.perform();
        backButton.click();
    }

    public void returnCustomersManagementPage() {
        clickOnBackToListCustomers();
    }
}
