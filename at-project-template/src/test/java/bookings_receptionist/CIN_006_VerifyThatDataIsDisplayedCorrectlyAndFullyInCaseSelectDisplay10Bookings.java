package bookings_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_006_VerifyThatDataIsDisplayedCorrectlyAndFullyInCaseSelectDisplay10Bookings extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatDataIsDisplayedCorrectlyAndFullyInCaseSelectDisplay10Bookings() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openBookingsManagementPage();

        bookingManagementPage.showTenBookingRows();

        // Expected Result CIN_006
        softAssert.assertEquals(bookingManagementPage.numberOfBookingsIsDisplay(), 10, "The number of reservations is different from 10");

        softAssert.assertAll();
    }
}
