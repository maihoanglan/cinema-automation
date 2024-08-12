package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_004_VerifyThatBookingManagementScreenIsOpenedByReceptionist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatBookingManagementScreenIsOpenedByReceptionist() {

        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openBookingsManagementPage();

        // Expected Result REC_004
        softAssert.assertEquals(bookingManagementPage.getTitleBookingManagementPage(), "Bookings", "Bookings Management page is not displayed");

        softAssert.assertAll();
    }
}
