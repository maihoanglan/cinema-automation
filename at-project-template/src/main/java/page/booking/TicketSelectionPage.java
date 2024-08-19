package page.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TicketSelectionPage {
    WebDriver driver;
    By extraAdultTicketSelector = By.xpath("//input[@id='quantity_ticket_1']/following-sibling::button");
    By continueButtonSelector = By.xpath("//div[@class='col-5 ticketInfo']//button[@onclick]");

    public TicketSelectionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addTicket() {
        driver.findElement(extraAdultTicketSelector).click();
    }

    public void clickContinueButton() {
        driver.findElement(continueButtonSelector).click();
    }

    public void buyTicket() {
        addTicket();
        clickContinueButton();
    }
}
