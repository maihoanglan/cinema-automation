package bookings_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_014_VerifyThatViewInvoiceOfThisBookingScreenIsOpened extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatViewInvoiceOfThisBookingScreenIsOpened() {

        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openBookingsManagementPage();

        bookingManagementPage.openViewInvoiceOfThisBookingPage();

        // Expected Result REC_014
        softAssert.assertEquals(viewInvoiceOfBookingPage.getTitleViewInvoiceOfBookingPage(), "View Invoices Of Booking", "View Invoices Of Booking page is not displayed");

        softAssert.assertAll();
    }
}
