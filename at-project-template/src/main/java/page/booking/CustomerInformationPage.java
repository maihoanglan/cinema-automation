package page.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerInformationPage {
    WebDriver driver;
    By continueButtonSelector = By.xpath("//div[@class='col-5 ticketInfo']//button[@onclick]");

    public CustomerInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmCustomerInformation() {
        driver.findElement(continueButtonSelector).click();
    }
}
