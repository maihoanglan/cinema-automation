package transactions_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_023_VerifyThatDataIsDisplayedCorrectlyAndFullyInCaseSelectDisplay5Transactions extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatDataIsDisplayedCorrectlyAndFullyInCaseSelectDisplay5Transactions() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openTransactionsCinemaManagementPage();

        transactionsCinemaPage.showFiveTransactionRows();

        // Expected Result CIN_023
        softAssert.assertEquals(transactionsCinemaPage.numberOfTransactionsIsDisplay(), 5, "The number of reservations is different from 5");

        softAssert.assertAll();
    }
}
