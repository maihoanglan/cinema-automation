package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    By loginButtonSelector = By.xpath("//a[@href='/DoubleTCinema/login']");
    By userAccountSelector = By.xpath("//button[@data-toggle='dropdown']");
    By logoutButtonSelector = By.xpath("//a[@href='/DoubleTCinema/logout?logoutStatus=true']");
    By registerButtonSelector = By.xpath("//a[@href='/DoubleTCinema/view_register']");
    By administratorButtonSelector = By.xpath("//a[@href='/DoubleTCinema/admin/home']");
    By cinemaFollowTabSelector = By.id("cinemaFollow-tab");
    By cinemaNameDropdownSelector = By.name("cinemaIdCinemaFollow");
    By movieNameDropdownSelector = By.name("movieIdCinemaFollow");
    By cinemaShowTimeDropdownSelector = By.name("showTimeCinemaFollow");
    By buyTicketButton = By.xpath("//div[@id='cinemaFollow']//form//a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLoginSection() {
        driver.findElement(loginButtonSelector).click();
    }

    public void openLoginPage() {
        clickOnLoginSection();
        By emailTextBoxSelector = By.id("email");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElement(emailTextBoxSelector).isDisplayed());
    }

    public String getEmailName() {
        return driver.findElement(userAccountSelector).getText();
    }

    public void clickOnEmailAccount() {
        driver.findElement(userAccountSelector).click();
    }

    public void clickOnLogoutSection() {
        driver.findElement(logoutButtonSelector).click();
    }

    public boolean isRegisterButtonDisplayed() {
        return driver.findElement(registerButtonSelector).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButtonSelector).isDisplayed();
    }

    public void clickOnAdministratorForReceptionistSection() {
        driver.findElement(administratorButtonSelector).click();
    }

    public void logout() {
        clickOnEmailAccount();
        clickOnLogoutSection();
    }

    public void openAdministratorForReceptionist() {
        clickOnEmailAccount();
        clickOnAdministratorForReceptionistSection();
        // Interact with elements of new tab
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    public void clickCinemaFollowTab() {
        driver.findElement(cinemaFollowTabSelector).click();
    }

    public void selectCinemaName() {
        WebElement cinemaNameDropdown = driver.findElement(cinemaNameDropdownSelector);
        cinemaNameDropdown.click();
        Select select = new Select(cinemaNameDropdown);
        select.selectByVisibleText("DoubleT Huế");
    }

    public void selectMovieName() {
        WebElement movieNameDropdown = driver.findElement(movieNameDropdownSelector);
        movieNameDropdown.click();
        Select select = new Select(movieNameDropdown);
        select.selectByVisibleText("Tuyệt đỉnh Kung Fu");
    }

    public void selectCinemaShowTime() {
        WebElement cinemaShowTimeDropdown = driver.findElement(cinemaShowTimeDropdownSelector);
        cinemaShowTimeDropdown.click();
        Select select = new Select(cinemaShowTimeDropdown);
        select.selectByVisibleText("23:59:00");
    }

    public void clickBuyTicketButton() {
        driver.findElement(buyTicketButton).click();
    }

    public void buyTicket() {
        clickCinemaFollowTab();
        selectCinemaName();
        selectMovieName();
        selectCinemaShowTime();
        clickBuyTicketButton();
    }
}
