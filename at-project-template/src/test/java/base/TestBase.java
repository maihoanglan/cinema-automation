package base;

import com.github.javafaker.Faker;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import page.*;
import page.booking.*;
import page.bookings_management.BookingsManagementPage;
import page.bookings_management.ViewBookingDetailPage;
import page.bookings_management.ViewInvoiceOfBookingPage;
import page.customer_credit_card.CustomersCreditCardPage;
import page.customer_credit_card.DepositForCustomerCreditCardPage;
import page.customers_management.CustomersManagementPage;
import page.customers_management.UpdateCustomerPage;
import page.customers_management.ViewBookingsOfCustomer;
import page.transactions_cinema.TransactionsCinemaPage;
import utils.ConfigReader;
import utils.ReadExcelFile;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    protected String titlePage;
    protected String randomAddress;
    protected int randomNumber;
    protected String randomMovieName;
    protected String randomEmail;
    protected ConfigReader config;
    protected ReadExcelFile readExcelFile;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected User user;
    protected DashboardPage dashboardPage;
    protected SoftAssert softAssert;
    protected Faker faker;
    protected TicketSelectionPage bookingInfoPage;
    protected SeatSelectionPage seatSelectionPage;
    protected BookingsManagementPage bookingManagementPage;
    protected ViewBookingDetailPage viewBookingDetailPage;
    protected ViewInvoiceOfBookingPage viewInvoiceOfBookingPage;
    protected CustomersManagementPage customersManagementPage;
    protected ViewBookingsOfCustomer viewBookingsOfCustomer;
    protected UpdateCustomerPage updateCustomerPage;
    protected CustomerInformationPage customerInformationPage;
    protected PaymentPage paymentPage;
    protected SuccessfulTransactionPage successfulTransactionPage;
    protected CustomersCreditCardPage customersCreditCardPage;
    protected DepositForCustomerCreditCardPage depositForCustomerCreditCardPage;
    protected TransactionsCinemaPage transactionsCinemaPage;
    protected ManageUserPage manageUserPage;

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
        bookingInfoPage = new TicketSelectionPage(driver);
        seatSelectionPage = new SeatSelectionPage(driver);
        bookingManagementPage = new BookingsManagementPage(driver);
        viewBookingDetailPage = new ViewBookingDetailPage(driver);
        viewInvoiceOfBookingPage = new ViewInvoiceOfBookingPage(driver);
        customersManagementPage = new CustomersManagementPage(driver);
        viewBookingsOfCustomer = new ViewBookingsOfCustomer(driver);
        updateCustomerPage = new UpdateCustomerPage(driver);
        customerInformationPage = new CustomerInformationPage(driver);
        paymentPage = new PaymentPage(driver);
        successfulTransactionPage = new SuccessfulTransactionPage(driver);
        customersCreditCardPage = new CustomersCreditCardPage(driver);
        depositForCustomerCreditCardPage = new DepositForCustomerCreditCardPage(driver);
        transactionsCinemaPage = new TransactionsCinemaPage(driver);
        manageUserPage = new ManageUserPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }
}
