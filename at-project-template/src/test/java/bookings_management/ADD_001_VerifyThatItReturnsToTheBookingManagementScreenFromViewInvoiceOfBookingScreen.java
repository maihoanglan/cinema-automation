package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class ADD_001_VerifyThatItReturnsToTheBookingManagementScreenFromViewInvoiceOfBookingScreen extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatItReturnsToTheBookingManagementScreenFromViewInvoiceOfBookingScreen() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openBookingsManagementPage();

        bookingManagementPage.openViewInvoiceOfThisBookingPage();

        viewInvoiceOfBookingPage.returnBookingManagementPage();

        // Expected Result ADD_001
        softAssert.assertEquals(bookingManagementPage.getTitleBookingManagementPage(), "Bookings", "Bookings Management page is not returned");

        softAssert.assertAll();
    }
}
