package page.bookings_management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewBookingDetailPage {
    WebDriver driver;
    String title;
    By titleViewBookingDetailSelector = By.xpath("//div[@class='card-body']/h4");
    By backToListBookingsButtonSelector = By.xpath("//p[@class='text-center']//a[@href='/DoubleTCinema/admin/bookings']");

    public ViewBookingDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        String titleViewBookingDetail = driver.findElement(titleViewBookingDetailSelector).getText();

        // Find the index where ' -- ID Booking: ' starts
        int endIndex = titleViewBookingDetail.indexOf(" -- ID Booking: ");

        if (endIndex != -1) {
            // Extract the substring from the beginning up to endIndex
            title = titleViewBookingDetail.substring(0, endIndex); // 'View Booking Detail'
        }
        return title;
    }

    public void returnBookingManagementPage() {
        driver.findElement(backToListBookingsButtonSelector).click();
    }
}
