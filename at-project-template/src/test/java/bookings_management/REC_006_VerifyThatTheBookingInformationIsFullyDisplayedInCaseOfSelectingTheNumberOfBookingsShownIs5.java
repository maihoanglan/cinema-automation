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
        // Login Success
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login unsuccessfully");

        homePage.openAdministratorForReceptionist();
        dashboardPage.openBookingsManagementPage();
        // Booking Management is Displayed
        softAssert.assertEquals(bookingManagementPage.getTitleOfPage(), "Bookings", "Bookings Management page is not displayed");

        bookingManagementPage.showFiveBookingRows();
        // Expected Result REC_006
        softAssert.assertEquals(bookingManagementPage.numberOfBookingsIsDisplay(), 5, "The number of reservations is different from 5");

        softAssert.assertAll();
    }
}
