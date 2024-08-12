package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_014_VerifyThatViewInvoiceOfThisBookingScreenIsOpened extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatViewInvoiceOfThisBookingScreenIsOpened() {
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
        // Expected Result REC_014
        softAssert.assertEquals(bookingManagementPage.getTitleViewInvoiceOfBookingPage(), "View Invoices Of Booking", "View Invoices Of Booking page is not displayed");

        softAssert.assertAll();
    }
}
