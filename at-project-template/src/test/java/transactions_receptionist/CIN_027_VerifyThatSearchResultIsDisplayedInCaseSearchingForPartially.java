package transactions_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_027_VerifyThatSearchResultIsDisplayedInCaseSearchingForPartially extends TestBase {
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

        dashboardPage.openTransactionsCinemaManagementPage();

        email = transactionsCinemaPage.getEmailOfFirstRow();

        partialWithEmail = email.substring(0, email.length() / 2);

        transactionsCinemaPage.search(partialWithEmail);

        // Expected Result CIN_027
        softAssert.assertTrue(transactionsCinemaPage.areAllEmailContains(partialWithEmail));

        softAssert.assertAll();
    }
}
