package transactions_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_028_VerifyThatSearchResultIsNotDisplayedInCaseDataNotFound extends TestBase {

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

        dashboardPage.openTransactionsCinemaManagementPage();

        transactionsCinemaPage.search(randomEmail);

        // Expected Result CIN_028
        softAssert.assertTrue(transactionsCinemaPage.isNoResultDisplayed(), "Have search results returned");

        softAssert.assertAll();
    }
}
