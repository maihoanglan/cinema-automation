package customers_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_019_VerifyThatSearchResultIsDisplayedInCaseSearchingForExactly extends TestBase {
    String email;

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatSearchResultIsDisplayedInCaseSearchingForExactly() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openCustomersManagementPage();

        email = customersManagementPage.getEmailOfFirstRow();

        customersManagementPage.search(email);

        // Expected Result CIN_019
        softAssert.assertTrue(customersManagementPage.areAllEmailContains(email), "Search exactly with email unsuccessfully");

        softAssert.assertAll();
    }
}
