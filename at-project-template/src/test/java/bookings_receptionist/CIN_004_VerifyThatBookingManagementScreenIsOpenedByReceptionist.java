package bookings_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_004_VerifyThatBookingManagementScreenIsOpenedByReceptionist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatBookingManagementScreenIsOpenedByReceptionist() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openBookingsManagementPage();

        // Expected Result CIN_004
        softAssert.assertEquals(bookingManagementPage.getTitle(), "Bookings", "Bookings Management page is not displayed");

        softAssert.assertAll();
    }
}
