package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    By emailTextBoxSelector = By.id("email");
    By passwordTextBoxSelector = By.id("password");
    By loginButtonSelector = By.className("btn");
    By errorMessageSelector = By.xpath("//*[@style='color: red;font-size: 15px;']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailTextBoxSelector).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordTextBoxSelector).sendKeys(password);
    }

    public void clickOnLoginButton() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElement(loginButtonSelector).isDisplayed());
        driver.findElement(loginButtonSelector).click();
    }

    public boolean isEmailTextBoxDisplayed() {
        return driver.findElement(emailTextBoxSelector).isDisplayed();
    }

    public boolean isPasswordTextBoxDisplayed() {
        return driver.findElement(passwordTextBoxSelector).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButtonSelector).isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessageSelector).isDisplayed();
    }

    public void login(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickOnLoginButton();
    }
}
