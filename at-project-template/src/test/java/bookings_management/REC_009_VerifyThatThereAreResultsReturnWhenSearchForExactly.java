package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_009_VerifyThatThereAreResultsReturnWhenSearchForExactly extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatThereAreResultsReturnWhenSearchForExactly() {

        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openBookingsManagementPage();

        // Expected Result REC_009
        softAssert.assertTrue(bookingManagementPage.searchForExactly(), "Exact match not found");

        softAssert.assertAll();
    }
}
