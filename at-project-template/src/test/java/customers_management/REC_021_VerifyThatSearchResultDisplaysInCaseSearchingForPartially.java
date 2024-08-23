package customers_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_021_VerifyThatSearchResultDisplaysInCaseSearchingForPartially extends TestBase {
    String email;
    String partialWithEmail;

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatSearchResultDisplaysInCaseSearchingForPartially() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openCustomersManagementPage();

        email = customersManagementPage.getEmailOfFirstRow();

        partialWithEmail = email.substring(0, email.length() / 2);

        customersManagementPage.search(partialWithEmail);

        // Expected Result REC_021
        softAssert.assertTrue(customersManagementPage.areAllEmailContains(partialWithEmail));

        softAssert.assertAll();
    }
}
