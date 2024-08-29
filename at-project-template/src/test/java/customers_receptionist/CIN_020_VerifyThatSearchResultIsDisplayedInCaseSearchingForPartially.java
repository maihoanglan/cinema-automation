package customers_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_020_VerifyThatSearchResultIsDisplayedInCaseSearchingForPartially extends TestBase {
    String email;
    String partialWithEmail;

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatSearchResultIsDisplayedInCaseSearchingForPartially() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openCustomersManagementPage();

        email = customersManagementPage.getEmailOfFirstRow();

        partialWithEmail = email.substring(0, email.length() / 2);

        customersManagementPage.search(partialWithEmail);

        // Expected Result CIN_020
        softAssert.assertTrue(customersManagementPage.areAllEmailContains(partialWithEmail));

        softAssert.assertAll();
    }
}
