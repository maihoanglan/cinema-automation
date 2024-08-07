package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    By loginButtonSelector = By.xpath("//a[@href='/DoubleTCinema/login']");
    By userAccountSelector = By.xpath("//button[@data-toggle='dropdown']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLoginButton() {
        driver.findElement(loginButtonSelector).click();
    }

    public void openLoginPage() {
        clickOnLoginButton();
        By emailTextBoxSelector = By.id("email");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElement(emailTextBoxSelector).isDisplayed());
    }

    public String getUserAccountName() {
        return driver.findElement(userAccountSelector).getText();
    }
}
