package bookings_management;

import base.TestBase;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class VerifyThatBookingManagementScreenIsOpenedByReceptionist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatBookingManagementScreenIsOpenedByReceptionist() {
        driver.get(config.getUrlHome());
        homePage.openLoginPage();

        loginPage.login(user);
        // Login Success
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login unsuccessfully");

        homePage.openAdministratorForReceptionist();
        dashboardPage.openBookingsManagementPage();
        // Expected Result REC_004
        softAssert.assertEquals(dashboardPage.getTitleOfPage(), "Bookings", "Bookings Management is not displayed");

        softAssert.assertAll();
    }
}
