package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_006_VerifyThatTheBookingInformationIsFullyDisplayedInCaseOfSelectingTheNumberOfBookingsShownIs5 extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatTheBookingInformationIsFullyDisplayedInCaseOfSelectingTheNumberOfBookingsShownIs5() {

        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openBookingsManagementPage();

        bookingManagementPage.showFiveBookingRows();

        // Expected Result REC_006
        softAssert.assertEquals(bookingManagementPage.numberOfBookingsIsDisplay(), 5, "The number of reservations is different from 5");

        softAssert.assertAll();
    }
}
