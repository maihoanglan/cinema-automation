package bookings_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_008_VerifyThatSearchResultIsDisplayedInCaseSearchingForExactly extends TestBase {
    String movieName;

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatSearchResultIsDisplayedInCaseSearchingForExactly() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openBookingsManagementPage();

        movieName = bookingManagementPage.getMovieNameOfFirstRow();

        bookingManagementPage.search(movieName);

        // Expected Result CIN_008
        softAssert.assertTrue(bookingManagementPage.areAllMovieNameContains(movieName), "Search exactly with movie name is not found");

        softAssert.assertAll();
    }
}
