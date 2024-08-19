package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_012_VerifyThatViewBookingDetailScreenIsOpened extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void TestVerifyThatViewBookingDetailScreenIsOpened() {

        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openBookingsManagementPage();

        bookingManagementPage.openViewBookingDetailsPage();

        // Expected Result REC_012
        softAssert.assertEquals(viewBookingDetailPage.getTitle(), "View Booking Detail", "View Booking Detail page is not displayed");

        softAssert.assertAll();
    }
}
