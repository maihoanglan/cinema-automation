package page.customers_management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateCustomerPage {
    WebDriver driver;
    By textAreaSelector = By.id("customerAddress");
    By updateButtonSelector = By.xpath("//button[@type='submit']");

    public UpdateCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnTextArea() {
        driver.findElement(textAreaSelector).click();
    }

    public void clearOnTextArea() {
        driver.findElement(textAreaSelector).clear();
    }

    public void sendKeysOnTextArea(String address) {
        driver.findElement(textAreaSelector).sendKeys(address);
    }

    public void clickOnUpdateButton() {
        driver.findElement(updateButtonSelector).click();
    }

    public void updateCustomerAddress(String address) {
        clickOnTextArea();
        clearOnTextArea();
        sendKeysOnTextArea(address);
        clickOnUpdateButton();
    }
}
