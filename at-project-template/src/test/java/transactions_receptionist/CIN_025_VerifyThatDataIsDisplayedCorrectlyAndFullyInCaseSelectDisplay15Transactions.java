package transactions_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_025_VerifyThatDataIsDisplayedCorrectlyAndFullyInCaseSelectDisplay15Transactions extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatDataIsDisplayedCorrectlyAndFullyInCaseSelectDisplay15Transactions() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openTransactionsCinemaManagementPage();

        transactionsCinemaPage.showFifteenTransactionRows();

        // Expected Result CIN_025
        softAssert.assertEquals(transactionsCinemaPage.numberOfTransactionsIsDisplay(), 15, "The number of reservations is different from 15");

        softAssert.assertAll();
    }
}
