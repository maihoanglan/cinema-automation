package bookings_management;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.DashboardPage;
import page.HomePage;
import page.LoginPage;
import utils.ConfigReader;
import utils.ReadExcelFile;

import java.time.Duration;

public class VerifyThatBookingManagementScreenIsOpenedByReceptionist {
    WebDriver driver;
    ConfigReader config;
    ReadExcelFile readExcelFile;
    LoginPage loginPage;
    HomePage homePage;
    User user;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        config = new ConfigReader();
        readExcelFile = new ReadExcelFile("src/test/resources/users.xlsx");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        dashboardPage = new DashboardPage(driver);

        user = new User();
        user.setEmail(readExcelFile.getCell(1, 0));
        user.setPassword(readExcelFile.getCell(1, 1));
        user.setName(readExcelFile.getCell(1, 2));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TestVerifyThatBookingManagementScreenIsOpenedByReceptionist() {
        SoftAssert softAssert = new SoftAssert();
        driver.get(config.getUrlHome());
        homePage.openLoginPage();

        loginPage.login(user);
        // Login Success
        softAssert.assertEquals(homePage.getUserAccountName(), user.getName(), "Login unsuccessfully");

        homePage.clickOnUserAccountSection();

        // Get current window handle
        String originalWindow = driver.getWindowHandle();
        // Click the link which opens in a new window
        homePage.clickOnAdministratorSection();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }
        dashboardPage.clickOnBookingsManagementMenu();
        softAssert.assertEquals(dashboardPage.getTitleOfPage(), "Bookings", "Bookings Management is not displayed");

        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }
}
