package customers_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_019_VerifyThatUpdateCustomerAddressSuccessfullyInCaseClickOnEditIconAtCustomersManagementScreen extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void testVerifyThatUpdateCustomerAddressSuccessfullyInCaseClickOnEditIconAtCustomersManagementScreen() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openCustomersManagementPage();

        customersManagementPage.openUpdateCustomerAddressPage();

        updateCustomerPage.updateCustomerAddress("TTHue");

        // Expected Result REC_019
        softAssert.assertEquals(customersManagementPage.getCustomerAddress(), "TTHue", "Addresses do not match");

        softAssert.assertAll();
    }
}
