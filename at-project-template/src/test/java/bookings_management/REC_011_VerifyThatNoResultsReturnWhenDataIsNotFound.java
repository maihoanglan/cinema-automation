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

        homePage.openAdministratorForReceptionist();

        dashboardPage.openBookingsManagementPage();

        // Expected Result REC_011
        softAssert.assertEquals(bookingManagementPage.searchForNoResult("Kung Fu Fu"), "NO DATA DISPLAYED ! PLEASE CHECK AGAIN !", "Have search results returned");

        softAssert.assertAll();
    }
}
