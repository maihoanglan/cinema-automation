package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_013_VerifyThatItReturnsToTheBookingManagementScreenFromViewBookingDetailScreen extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatItReturnsToTheBookingManagementScreenFromViewBookingDetailScreen() {
        driver.get(config.getUrlHome());
        homePage.openLoginPage();

        loginPage.login(user);
        // Login Success
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login unsuccessfully");

        homePage.openAdministratorForReceptionist();
        dashboardPage.openBookingsManagementPage();
        // Booking Management is Displayed
        softAssert.assertEquals(bookingManagementPage.getTitleOfPage(), "Bookings", "Bookings Management page is not displayed");

        bookingManagementPage.openViewBookingDetailsPage();
        // View Booking Detail is displayed
        softAssert.assertEquals(bookingManagementPage.getTitleViewBookingPage(), "View Booking Detail", "View Booking Detail page is not displayed");

        bookingManagementPage.returnBookingManagementPage();
        // Expected Result REC_013
        softAssert.assertEquals(bookingManagementPage.getTitleOfPage(), "Bookings", "Bookings Management page is not returned");

        softAssert.assertAll();
    }
}
