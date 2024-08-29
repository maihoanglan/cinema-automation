package bookings_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_009_VerifyThatSearchResultIsDisplayedInCaseSearchingForPartially extends TestBase {
    String movieName;
    String partialWithMovieName;

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatSearchResultIsDisplayedInCaseSearchingForPartially() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openBookingsManagementPage();

        movieName = bookingManagementPage.getMovieNameOfFirstRow();

        partialWithMovieName = movieName.substring(0, movieName.length() / 2);

        bookingManagementPage.search(partialWithMovieName);

        // Expected Result CIN_009
        softAssert.assertTrue(bookingManagementPage.areAllMovieNameContains(partialWithMovieName), "Search partial with movie name is not found");

        softAssert.assertAll();
    }
}
