package customers_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_022_VerifyThatSearchResultsDoNotDisplayInCaseDataIsNotFound extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void testVerifyThatSearchResultsDoNotDisplayInCaseDataIsNotFound() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openCustomersManagementPage();

        // Expected Result REC_022
        softAssert.assertEquals(customersManagementPage.searchForNoResult("maihoanglan@gmail.com"), "NO DATA DISPLAYED ! PLEASE CHECK AGAIN !", "Have search results returned");

        softAssert.assertAll();
    }
}
