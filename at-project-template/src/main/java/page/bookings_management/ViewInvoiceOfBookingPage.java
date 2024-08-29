package page.bookings_management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewInvoiceOfBookingPage {
    WebDriver driver;
    String title;
    By titleViewInvoiceOfBookingSelector = By.xpath("//div[@class='card-body']/h4");
    By backToListBookingsButtonSelector = By.xpath("//p[@class='text-center']//a[@href='/DoubleTCinema/admin/bookings']");

    public ViewInvoiceOfBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBookingID() {
        String originalString = driver.findElement(titleViewInvoiceOfBookingSelector).getText();

        // Find the index of ": " which marks the start of the booking ID
        int index = originalString.indexOf(": ");

        // Extract the substring starting from index + 2 to the end
        String bookingID = originalString.substring(index + 2);
        return bookingID;
    }

    public String getTitle() {
        String originalString = driver.findElement(titleViewInvoiceOfBookingSelector).getText();

        // Find the index of ": "
        int index = originalString.indexOf(": ");

        // Extract the substring from the start of the original string to the index
        String title = originalString.substring(0, index);

        // Trim any extra whitespace from the end
        title = title.trim();

        return title;
    }

    public void returnBookingManagementPage() {
        driver.findElement(backToListBookingsButtonSelector).click();
    }
}
