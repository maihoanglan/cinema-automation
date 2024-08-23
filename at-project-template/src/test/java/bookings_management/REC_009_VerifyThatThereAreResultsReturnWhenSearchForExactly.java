package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_009_VerifyThatThereAreResultsReturnWhenSearchForExactly extends TestBase {
    String movieName;

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void TestVerifyThatThereAreResultsReturnWhenSearchForExactly() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openBookingsManagementPage();

        movieName = bookingManagementPage.getMovieNameOfFirstRow();

        bookingManagementPage.search(movieName);

        // Expected Result REC_009
        softAssert.assertTrue(bookingManagementPage.areAllMovieNameContains(movieName) , "Search exactly with movie name unsuccessfully");

        softAssert.assertAll();
    }
}
