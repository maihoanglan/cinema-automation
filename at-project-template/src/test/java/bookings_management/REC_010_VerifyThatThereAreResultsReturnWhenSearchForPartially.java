package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_010_VerifyThatThereAreResultsReturnWhenSearchForPartially extends TestBase {
    String movieName;
    String partialWithMovieName;

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void TestVerifyThatThereAreResultsReturnWhenSearchForPartially() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openBookingsManagementPage();

        movieName = bookingManagementPage.getMovieNameOfFirstRow();

        partialWithMovieName = movieName.substring(0, movieName.length()/2);

        bookingManagementPage.search(partialWithMovieName);

        // Expected Result REC_010
        softAssert.assertTrue(bookingManagementPage.areAllMovieNameContains(partialWithMovieName), "Partial match not found");

        softAssert.assertAll();
    }
}
