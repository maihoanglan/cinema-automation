package page.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeatSelectionPage {
    WebDriver driver;
    By seatAvailableSelector = By.xpath("//div[@class='boxes']//div[@onclick]");
    By continueButtonSelector = By.xpath("//div[@class='col-5 ticketInfo']//button[@onclick]");

    public SeatSelectionPage(WebDriver driver) {
        this.driver = driver;
    }

    //  Handle seat is selected
    public void clickSeat() {
        driver.findElement(seatAvailableSelector).click();
    }

    public void clickContinueButtonSeatSelection() {
        driver.findElement(continueButtonSelector).click();
    }

    public void selectSeat() {
        clickSeat();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickContinueButtonSeatSelection();
    }
}
