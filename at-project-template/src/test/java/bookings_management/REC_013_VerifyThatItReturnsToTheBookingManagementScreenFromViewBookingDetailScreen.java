package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_013_VerifyThatItReturnsToTheBookingManagementScreenFromViewBookingDetailScreen extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void TestVerifyThatItReturnsToTheBookingManagementScreenFromViewBookingDetailScreen() {

        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openBookingsManagementPage();

        bookingManagementPage.openViewBookingDetailsPage();

        viewBookingDetailPage.returnBookingManagementPage();

        // Expected Result REC_013
        softAssert.assertEquals(bookingManagementPage.getTitle(), "Bookings", "Bookings Management page is not returned");

        softAssert.assertAll();
    }
}
