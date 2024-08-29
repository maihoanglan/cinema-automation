package customers_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_017_VerifyThatCustomersManagementScreenIsOpenedAfterClickingOnBackToListCustomersButtonAtViewBookingsOfCustomerScreen extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatCustomersManagementScreenIsOpenedAfterClickingOnBackToListCustomersButtonAtViewBookingsOfCustomerScreen() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openCustomersManagementPage();

        customersManagementPage.openViewBookingsOfCustomerPage();

        viewBookingsOfCustomer.returnCustomersManagementPage();

        // Expected Result CIN_017
        softAssert.assertEquals(customersManagementPage.getTitle(), "Customers", "Customers Management page is not returned");

        softAssert.assertAll();
    }
}
