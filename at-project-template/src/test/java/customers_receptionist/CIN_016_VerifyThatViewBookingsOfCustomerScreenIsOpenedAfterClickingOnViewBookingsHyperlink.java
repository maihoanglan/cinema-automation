package customers_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_016_VerifyThatViewBookingsOfCustomerScreenIsOpenedAfterClickingOnViewBookingsHyperlink extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatViewBookingsOfCustomerScreenIsOpenedAfterClickingOnViewBookingsHyperlink() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openCustomersManagementPage();

        titlePage = customersManagementPage.getCustomerNameInCustomersManagementPage();

        customersManagementPage.openViewBookingsOfCustomerPage();

        // Expected Result CIN_016
        softAssert.assertEquals(viewBookingsOfCustomer.getTitle(), "View Bookings Of Customer", "View Bookings Of Customer page is not returned");
        softAssert.assertEquals(titlePage, viewBookingsOfCustomer.getCustomerName(), "Name does not match");

        softAssert.assertAll();
    }
}
