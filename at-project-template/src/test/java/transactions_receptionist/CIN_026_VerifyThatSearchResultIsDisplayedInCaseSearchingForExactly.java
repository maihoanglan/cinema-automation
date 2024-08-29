package transactions_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_026_VerifyThatSearchResultIsDisplayedInCaseSearchingForExactly extends TestBase {
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

        dashboardPage.openTransactionsCinemaManagementPage();

        email = transactionsCinemaPage.getEmailOfFirstRow();

        transactionsCinemaPage.search(email);

        // Expected Result CIN_026
        softAssert.assertTrue(transactionsCinemaPage.areAllEmailContains(email), "Search exactly with email unsuccessfully");

        softAssert.assertAll();
    }
}
