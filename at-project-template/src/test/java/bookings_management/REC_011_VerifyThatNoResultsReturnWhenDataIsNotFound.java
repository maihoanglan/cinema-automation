package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_011_VerifyThatNoResultsReturnWhenDataIsNotFound extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatNoResultsReturnWhenDataIsNotFound() {
        driver.get(config.getUrlHome());
        homePage.openLoginPage();

        loginPage.login(user);
        // Login Success
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login unsuccessfully");

        homePage.openAdministratorForReceptionist();
        dashboardPage.openBookingsManagementPage();
        // Booking Management is Displayed
        softAssert.assertEquals(bookingManagementPage.getTitleOfPage(), "Bookings", "Bookings Management page is not displayed");

        bookingManagementPage.searchForNoResults();
        // Expected Result REC_011
        softAssert.assertEquals(bookingManagementPage.verifySearchForNoResults(), "NO DATA DISPLAYED ! PLEASE CHECK AGAIN !", "Have search results returned");

        softAssert.assertAll();
    }
}
