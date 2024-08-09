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
    User user;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        config = new ConfigReader();
        readExcelFile = new ReadExcelFile("src/test/resources/users.xlsx");

        loginPage = new LoginPage(driver);
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
        driver.get(config.getUrlDashboard());

        loginPage.login(user);
        dashboardPage.clickOnBookingsManagementMenu();
        // Expected Result REC_004
        softAssert.assertEquals(dashboardPage.getTitleOfPage(), "Bookings", "Bookings Management Page not displayed");

        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }
}
