package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class ADD_001_VerifyThatItReturnsToTheBookingManagementScreenFromViewInvoiceOfBookingScreen extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatItReturnsToTheBookingManagementScreenFromViewInvoiceOfBookingScreen() {
        driver.get(config.getUrlHome());
        homePage.openLoginPage();

        loginPage.login(user);
        // Login Success
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login unsuccessfully");

        homePage.openAdministratorForReceptionist();
        dashboardPage.openBookingsManagementPage();
        // Booking Management is Displayed
        softAssert.assertEquals(bookingManagementPage.getTitleOfPage(), "Bookings", "Bookings Management page is not displayed");

        bookingManagementPage.openViewInvoiceOfThisBookingPage();
        // View Booking Detail is displayed
        softAssert.assertEquals(bookingManagementPage.getTitleViewInvoiceOfBookingPage(), "View Invoices Of Booking", "View Invoices Of Booking page is not displayed");

        bookingManagementPage.returnBookingManagementPage();
        // Expected Result ADD_001
        softAssert.assertEquals(bookingManagementPage.getTitleOfPage(), "Bookings", "Bookings Management page is not returned");

        softAssert.assertAll();
    }
}
