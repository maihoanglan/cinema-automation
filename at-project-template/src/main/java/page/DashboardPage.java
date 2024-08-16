package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;
    By bookingsManagementMenuSelector = By.xpath("//a[@href='/DoubleTCinema/admin/bookings']");
    By customersManagementMenuSelector = By.xpath("//a[@href='/DoubleTCinema/admin/customers']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openBookingsManagementPage() {
        driver.findElement(bookingsManagementMenuSelector).click();
    }

    public void openCustomersManagementPage() {
        driver.findElement(customersManagementMenuSelector).click();
    }
}
