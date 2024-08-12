package page;

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

    public String getTitleViewInvoiceOfBookingPage() {
        String titleViewInvoiceOfBooking = driver.findElement(titleViewInvoiceOfBookingSelector).getText();

        // Find the index where ' -- ID Booking: ' starts
        int endIndex = titleViewInvoiceOfBooking.indexOf(" -- ID Booking: ");

        if (endIndex != -1) {
            // Extract the substring from the beginning up to endIndex
            title = titleViewInvoiceOfBooking.substring(0, endIndex); // 'View Invoices Of Booking'
        }
        return title;
    }

    public void returnBookingManagementPage() {
        driver.findElement(backToListBookingsButtonSelector).click();
    }
}
