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
    By errorMessageSelector = By.xpath("//h1[text()='Tài khoản hoặc mật khẩu không đúng!']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailTextBoxSelector).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordTextBoxSelector).sendKeys(password);
    }

    public void clickOnLoginSection() {
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

    public String getErrorMessage() {
        return driver.findElement(errorMessageSelector).getText();
    }

    public void login(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickOnLoginSection();
    }
}
