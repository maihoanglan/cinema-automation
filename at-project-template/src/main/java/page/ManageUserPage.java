package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManageUserPage {
    WebDriver driver;
    By customerNameSelector = By.id("customerName");
    By customerEmailSelector = By.id("customerEmail");

    public ManageUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getReceptionistName() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElement(customerNameSelector).isDisplayed());
        return driver.findElement(customerNameSelector).getAttribute("value");
    }

    public String getReceptionistEmail() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElement(customerEmailSelector).isDisplayed());
        return driver.findElement(customerEmailSelector).getAttribute("value");
    }
}
