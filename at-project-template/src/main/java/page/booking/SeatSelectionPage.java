package page.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeatSelectionPage {
    WebDriver driver;
    By titlePageSelector = By.xpath("//h4[text()='Chọn ghế']");
    By seatButtonSelector = By.xpath("//div[@class='boxes']/div");
    By continueButtonSeatSelectionSelector = By.xpath("//div[@class='col-5 ticketInfo']//button");

    public SeatSelectionPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleSeatSelectionPage() {
        return driver.findElement(titlePageSelector).getText();
    }

    public void clickSeat() {
        driver.findElement(seatButtonSelector).click();
    }

    public void clickContinueButtonSeatSelection() {
        WebElement element = driver.findElement(By.xpath("//div[@class='col-5 ticketInfo']//button"));
        element.click();
    }

    public void selectSeat() {
        clickSeat();
        clickContinueButtonSeatSelection();
    }
}
