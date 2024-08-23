package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_011_VerifyThatNoResultsReturnWhenDataIsNotFound extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
        randomMovieName = faker.book().title();
    }

    @Test
    public void TestVerifyThatNoResultsReturnWhenDataIsNotFound() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openBookingsManagementPage();

        bookingManagementPage.search(randomMovieName);

        // Expected Result REC_011
        softAssert.assertTrue(bookingManagementPage.isNoResultDisplayed(), "Have search results returned");

        softAssert.assertAll();
    }
}
