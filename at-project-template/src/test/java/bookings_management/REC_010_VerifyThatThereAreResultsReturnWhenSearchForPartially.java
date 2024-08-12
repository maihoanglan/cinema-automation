package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_010_VerifyThatThereAreResultsReturnWhenSearchForPartially extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatThereAreResultsReturnWhenSearchForExactly() {
        driver.get(config.getUrlHome());
        homePage.openLoginPage();

        loginPage.login(user);
        // Login Success
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login unsuccessfully");

        homePage.openAdministratorForReceptionist();
        dashboardPage.openBookingsManagementPage();
        // Booking Management is Displayed
        softAssert.assertEquals(bookingManagementPage.getTitleOfPage(), "Bookings", "Bookings Management page is not displayed");

        bookingManagementPage.searchForPartially();
        // Expected Result REC_010
        softAssert.assertTrue(bookingManagementPage.searchForPartially(), "Partial match not found");

        softAssert.assertAll();
    }
}
