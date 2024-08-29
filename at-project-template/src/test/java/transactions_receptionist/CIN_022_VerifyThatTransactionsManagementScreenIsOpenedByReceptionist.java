package transactions_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_022_VerifyThatTransactionsManagementScreenIsOpenedByReceptionist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatTransactionsManagementScreenIsOpenedByReceptionist() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openTransactionsCinemaManagementPage();

        // Expected Result CIN_022
        softAssert.assertEquals(transactionsCinemaPage.getTitle(), "Transactions Cinema", "Transactions Management screen is not displayed");

        softAssert.assertAll();
    }
}
