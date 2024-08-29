package transactions_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_024_VerifyThatDataIsDisplayedCorrectlyAndFullyInCaseSelectDisplay10Transactions extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatDataIsDisplayedCorrectlyAndFullyInCaseSelectDisplay10Transactions() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openTransactionsCinemaManagementPage();

        transactionsCinemaPage.showTenTransactionRows();

        // Expected Result CIN_024
        softAssert.assertEquals(transactionsCinemaPage.numberOfTransactionsIsDisplay(), 10, "The number of reservations is different from 10");

        softAssert.assertAll();
    }
}
