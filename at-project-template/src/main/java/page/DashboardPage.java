package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    By bookingsManagementMenuSelector = By.xpath("//a[@href='/DoubleTCinema/admin/bookings']");
    By customersManagementMenuSelector = By.xpath("//a[@href='/DoubleTCinema/admin/customers']");
    By transactionsCinemaManagementMenuSelector = By.xpath("//a[@href='/DoubleTCinema/admin/transactionsCinema']");
    By customersCreditCardSelector = By.xpath("//a[@href='/DoubleTCinema/admin/accountsBanking']");
    By userAccountSelector = By.xpath("//img[@src='/DoubleTCinema/resources/images/user/no_image_user.png']");
    By logoutSelector = By.xpath("//a[@href='/DoubleTCinema/logout?logoutStatus=true']");
    By manageProfileButtonSelector = By.xpath("//a[@href='/DoubleTCinema/manage_user']");
    By userNameSelector = By.xpath("//div[@aria-labelledby='UserDropdown']//div//p");
    By userEmailSelector = By.xpath("//div[@aria-labelledby='UserDropdown']//div//p[2]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openBookingsManagementPage() {
        driver.findElement(bookingsManagementMenuSelector).click();
    }

    public void openCustomersManagementPage() {
        driver.findElement(customersManagementMenuSelector).click();
    }

    public void openCustomersCreditCardManagementPage() {
        driver.findElement(customersCreditCardSelector).click();
    }

    public void openTransactionsCinemaManagementPage() {
        driver.findElement(transactionsCinemaManagementMenuSelector).click();
    }

    public void viewUserAccount() {
        driver.findElement(userAccountSelector).click();
    }

    private void clickOnLogoutButton() {
        driver.findElement(logoutSelector).click();
    }

    public void openManageProfilePage() {
        driver.findElement(manageProfileButtonSelector).click();
        // Interact with elements of new tab
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    public void logout() {
        viewUserAccount();
        clickOnLogoutButton();
    }

    public String getUserName() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElement(userNameSelector).isDisplayed());
        return driver.findElement(userNameSelector).getText();
    }

    public String getUserEmail() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElement(userEmailSelector).isDisplayed());
        return driver.findElement(userEmailSelector).getText();
    }
}
