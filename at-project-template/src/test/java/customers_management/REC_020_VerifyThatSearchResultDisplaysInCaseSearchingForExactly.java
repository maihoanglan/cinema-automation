package customers_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_020_VerifyThatSearchResultDisplaysInCaseSearchingForExactly extends TestBase {
    String email;

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatSearchResultDisplaysInCaseSearchingForExactly() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openCustomersManagementPage();

        email = customersManagementPage.getEmailOfFirstRow();

        customersManagementPage.search(email);

        // Expected Result REC_020
        softAssert.assertTrue(customersManagementPage.areAllEmailContains(email), "Search exactly with email unsuccessfully");

        softAssert.assertAll();
    }
}
