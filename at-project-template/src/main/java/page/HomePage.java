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
    By cinemaShowDateDropDownSelector = By.name("showDateCinemaFollow");
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

    public void openDashboardPage() {
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

    public void clickBuyTicketButton() {
        driver.findElement(buyTicketButton).click();
    }

    public void chooseCinema(String cinemaName) {
        WebElement name = driver.findElement(cinemaNameDropdownSelector);
        name.click();
        Select select = new Select(name);
        select.selectByVisibleText(cinemaName);
    }

    public void chooseMovie(String movieName) {
        WebElement movie = driver.findElement(movieNameDropdownSelector);
        movie.click();
        Select select = new Select(movie);
        select.selectByVisibleText(movieName);
    }

    public void chooseShowDate(String showDate) {
        WebElement date = driver.findElement(cinemaShowDateDropDownSelector);
        date.click();
        date.sendKeys(showDate);
    }

    public void chooseShowTime(String showTime) {
        WebElement time = driver.findElement(cinemaShowTimeDropdownSelector);
        time.click();
        Select select = new Select(time);
        select.selectByVisibleText(showTime);
    }

    public void quickSearchTicket(String cinemaName, String movieName, String showDate, String showTime) {
        clickCinemaFollowTab();
        chooseCinema(cinemaName);
        chooseMovie(movieName);
        chooseShowDate(showDate);
        chooseShowTime(showTime);
        clickBuyTicketButton();
    }
}
