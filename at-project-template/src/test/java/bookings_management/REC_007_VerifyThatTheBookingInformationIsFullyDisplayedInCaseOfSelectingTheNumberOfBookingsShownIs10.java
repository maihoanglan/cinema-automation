package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_007_VerifyThatTheBookingInformationIsFullyDisplayedInCaseOfSelectingTheNumberOfBookingsShownIs10 extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatTheBookingInformationIsFullyDisplayedInCaseOfSelectingTheNumberOfBookingsShownIs10() {

        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openBookingsManagementPage();

        bookingManagementPage.showTenBookingRows();

        // Expected Result REC_007
        softAssert.assertEquals(bookingManagementPage.numberOfBookingsIsDisplay(), 10, "The number of reservations is different from 10");

        softAssert.assertAll();
    }
}
