package bookings_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_011_VerifyThatViewBookingDetailScreenIsOpenedAfterClickingOnViewBookingDetailsHyperlink extends TestBase {
    String bookingID;

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatViewBookingDetailScreenIsOpenedAfterClickingOnViewBookingDetailsHyperlink() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openBookingsManagementPage();

        bookingID = bookingManagementPage.getFirstBookingID();

        bookingManagementPage.openViewBookingDetailsPage();

        // Expected Result CIN_011
        softAssert.assertEquals(viewBookingDetailPage.getTitle(), "View Booking Detail -- ID Booking", "Title name not match");
        softAssert.assertEquals(viewBookingDetailPage.getBookingID(), bookingID, "Booking ID not match");

        softAssert.assertAll();
    }
}
