package bookings_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_014_VerifyThatBookingsManagementScreenIsOpenedAfterClickingOnBackToListBookingsAtViewInvoicesOfBookingScreen extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatBookingsManagementScreenIsOpenedAfterClickingOnBackToListBookingsAtViewInvoicesOfBookingScreen() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openBookingsManagementPage();

        bookingManagementPage.openViewInvoiceOfThisBookingPage();

        viewInvoiceOfBookingPage.returnBookingManagementPage();

        // Expected Result CIN_014
        softAssert.assertEquals(bookingManagementPage.getTitle(), "Bookings", "Bookings Management page is not returned");

        softAssert.assertAll();
    }
}
