package customers_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_017_VerifyThatViewBookingsOfCustomerScreenDisplaysInCaseClickOnViewBookingsHyperlinkAtCustomersManagementScreen extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatViewBookingsOfCustomerScreenDisplaysInCaseClickOnViewBookingsHyperlinkAtCustomersManagementScreen() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openCustomersManagementPage();

        titlePage = customersManagementPage.getCustomerNameInCustomersManagementPage();

        customersManagementPage.openViewBookingsOfCustomerPage();

        // Expected Result REC_017
        softAssert.assertEquals(viewBookingsOfCustomer.getTitle(), "View Bookings Of Customer", "View Bookings Of Customer page is not returned");
        softAssert.assertEquals(titlePage, viewBookingsOfCustomer.getCustomerName(), "Name does not match");

        softAssert.assertAll();
    }
}
