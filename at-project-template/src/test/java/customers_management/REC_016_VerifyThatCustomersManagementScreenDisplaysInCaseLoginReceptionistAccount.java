package customers_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_016_VerifyThatCustomersManagementScreenDisplaysInCaseLoginReceptionistAccount extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void testVerifyThatCustomersManagementScreenDisplaysInCaseLoginReceptionistAccount() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openCustomersManagementPage();

        // Expected Result REC_016
        softAssert.assertEquals(customersManagementPage.getTitleCustomersManagementPage(), "Customers", "Customers Management page is not displayed");

        softAssert.assertAll();
    }
}
