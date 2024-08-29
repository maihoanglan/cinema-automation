package customers_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_021_VerifyThatSearchResultIsNotDisplayedInCaseDataNotFound extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
        randomEmail = faker.internet().emailAddress();
    }

    @Test
    public void testVerifyThatSearchResultIsNotDisplayedInCaseDataNotFound() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openCustomersManagementPage();

        customersManagementPage.search(randomEmail);

        // Expected Result CIN_021
        softAssert.assertTrue(customersManagementPage.isNoResultDisplayed(), "Have search results returned");

        softAssert.assertAll();
    }
}
