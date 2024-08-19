package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_010_VerifyThatThereAreResultsReturnWhenSearchForPartially extends TestBase {

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

        // Expected Result REC_010
        softAssert.assertTrue(bookingManagementPage.searchMovieNameHasResult(bookingManagementPage.getPartiallyMovieNameExistsInDB()), "Partial match not found");

        softAssert.assertAll();
    }
}
