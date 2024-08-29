package bookings_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_007_VerifyThatDataIsDisplayedCorrectlyAndFullyInCaseSelectDisplay15Bookings extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatDataIsDisplayedCorrectlyAndFullyInCaseSelectDisplay15Bookings() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openBookingsManagementPage();

        bookingManagementPage.showFifteenBookingRows();

        // Expected Result CIN_007
        softAssert.assertEquals(bookingManagementPage.numberOfBookingsIsDisplay(), 15, "The number of reservations is different from 15");

        softAssert.assertAll();
    }
}
