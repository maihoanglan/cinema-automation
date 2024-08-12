package base;

import com.github.javafaker.Faker;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import page.*;
import page.booking.BookingInfoPage;
import page.booking.SeatSelectionPage;
import utils.ConfigReader;
import utils.ReadExcelFile;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    protected ConfigReader config;
    protected ReadExcelFile readExcelFile;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected User user;
    protected DashboardPage dashboardPage;
    protected SoftAssert softAssert;
    protected Faker faker;
    protected BookingInfoPage bookingInfoPage;
    protected SeatSelectionPage seatSelectionPage;
    protected BookingManagementPage bookingManagementPage;
    protected ViewBookingDetailPage viewBookingDetailPage;
    protected ViewInvoiceOfBookingPage viewInvoiceOfBookingPage;

    @BeforeClass
    public void navigate() {
        driver = new ChromeDriver();
        config = new ConfigReader();
        readExcelFile = new ReadExcelFile("src/test/resources/users.xlsx");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        dashboardPage = new DashboardPage(driver);
        softAssert = new SoftAssert();
        faker = new Faker();
        bookingInfoPage = new BookingInfoPage(driver);
        seatSelectionPage = new SeatSelectionPage(driver);
        bookingManagementPage = new BookingManagementPage(driver);
        viewBookingDetailPage = new ViewBookingDetailPage(driver);
        viewInvoiceOfBookingPage = new ViewInvoiceOfBookingPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }
}
