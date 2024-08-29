package bookings_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_012_VerifyThatBookingsManagementScreenIsOpenedAfterClickingOnBackToListBookingsAtViewBookingDetailScreen extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatBookingsManagementScreenIsOpenedAfterClickingOnBackToListBookingsAtViewBookingDetailScreen() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openBookingsManagementPage();

        bookingManagementPage.openViewBookingDetailsPage();

        viewBookingDetailPage.returnBookingManagementPage();

        // Expected Result CIN_012
        softAssert.assertEquals(bookingManagementPage.getTitle(), "Bookings", "Bookings Management screen is not displayed");

        softAssert.assertAll();
    }
}
