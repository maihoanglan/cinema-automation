package bookings_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_010_VerifyThatSearchResultIsNotDisplayedInCaseDataNotFound extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
        randomMovieName = faker.book().title();
    }

    @Test
    public void testVerifyThatSearchResultIsNotDisplayedInCaseDataNotFound() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openBookingsManagementPage();

        bookingManagementPage.search(randomMovieName);

        // Expected Result CIN_010
        softAssert.assertTrue(bookingManagementPage.isNoResultDisplayed(), "Have search results returned");

        softAssert.assertAll();
    }
}
