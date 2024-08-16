package customers_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_020_VerifyThatSearchResultDisplaysInCaseSearchingForExactly extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void testVerifyThatSearchResultDisplaysInCaseSearchingForExactly() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openCustomersManagementPage();

        // Expected Result REC_020
        softAssert.assertTrue(customersManagementPage.search("maihoanglan1997@gmail.com"), "Exactly match not found");

        softAssert.assertAll();
    }
}
