package page.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingInfoPage {
    WebDriver driver;
    By titlePageSelector = By.xpath("//h4[text()='Thông tin đặt vé']");
    By extraAdultTicketSelector = By.xpath("//input[@id='quantity_ticket_1']/following-sibling::button");
    By continueButtonBookingInfoSelector = By.xpath("//div[@class='col-5 ticketInfo']//button");

    public BookingInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleBookingInfoPage() {
        return driver.findElement(titlePageSelector).getText();
    }

    public void addAdultTicket() {
        driver.findElement(extraAdultTicketSelector).click();
    }

    public void clickContinueButtonBookingInfo() {
        driver.findElement(continueButtonBookingInfoSelector).click();
    }

    public void order() {
        addAdultTicket();
        clickContinueButtonBookingInfo();
    }
}
