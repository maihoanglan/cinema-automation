package bookings_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_013_VerifyThatViewInvoicesOfBookingScreenIsOpenedAfterClickingOnViewInvoiceOfThisBookingHyperlink extends TestBase {
    String bookingId;

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatViewInvoicesOfBookingScreenIsOpenedAfterClickingOnViewInvoiceOfThisBookingHyperlink() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openBookingsManagementPage();

        bookingId = bookingManagementPage.getFirstBookingID();

        bookingManagementPage.openViewInvoiceOfThisBookingPage();

        // Expected Result CIN_013
        softAssert.assertEquals(viewInvoiceOfBookingPage.getTitle(), "View Invoices Of Booking -- ID Booking", "Title name not match");
        softAssert.assertEquals(viewInvoiceOfBookingPage.getBookingID(), bookingId, "Booking ID not match");

        softAssert.assertAll();
    }
}
