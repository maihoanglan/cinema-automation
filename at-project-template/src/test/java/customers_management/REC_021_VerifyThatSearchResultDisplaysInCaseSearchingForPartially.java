package customers_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_021_VerifyThatSearchResultDisplaysInCaseSearchingForPartially extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void testVerifyThatSearchResultDisplaysInCaseSearchingForPartially() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openCustomersManagementPage();

        // Expected Result REC_021
        softAssert.assertTrue(customersManagementPage.search("maihoanglan199"), "Partially match not found");

        softAssert.assertAll();
    }
}
