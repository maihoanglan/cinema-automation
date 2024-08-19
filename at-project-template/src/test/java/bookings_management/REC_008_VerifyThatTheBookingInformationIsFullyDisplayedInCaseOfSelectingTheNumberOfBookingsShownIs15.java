package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_008_VerifyThatTheBookingInformationIsFullyDisplayedInCaseOfSelectingTheNumberOfBookingsShownIs15 extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void TestVerifyThatTheBookingInformationIsFullyDisplayedInCaseOfSelectingTheNumberOfBookingsShownIs15() {

        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openBookingsManagementPage();

        bookingManagementPage.showFifteenBookingRows();

        // Expected Result REC_008
        softAssert.assertEquals(bookingManagementPage.numberOfBookingsIsDisplay(), 15, "The number of reservations is different from 15");

        softAssert.assertAll();
    }
}
