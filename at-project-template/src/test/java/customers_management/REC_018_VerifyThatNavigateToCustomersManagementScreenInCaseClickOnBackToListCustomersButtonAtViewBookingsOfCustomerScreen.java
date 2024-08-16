package customers_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_018_VerifyThatNavigateToCustomersManagementScreenInCaseClickOnBackToListCustomersButtonAtViewBookingsOfCustomerScreen extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void testVerifyThatNavigateToCustomersManagementScreenInCaseClickOnBackToListCustomersButtonAtViewBookingsOfCustomerScreen() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openCustomersManagementPage();

        customersManagementPage.openViewBookingsOfCustomerPage();

        viewBookingsOfCustomer.returnCustomersManagementPage();

        // Expected Result REC_018
        softAssert.assertEquals(customersManagementPage.getTitleCustomersManagementPage(), "Customers", "Customers Management page is not returned");

        softAssert.assertAll();
    }
}
