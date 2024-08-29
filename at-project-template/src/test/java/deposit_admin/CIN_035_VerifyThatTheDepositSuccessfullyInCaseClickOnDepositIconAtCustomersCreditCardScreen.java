package deposit_admin;

import base.TestBase;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_035_VerifyThatTheDepositSuccessfullyInCaseClickOnDepositIconAtCustomersCreditCardScreen extends TestBase {
    User admin;
    int randomAmount;
    String depositBalance;
    String transactionDate;
    int randomNumber;

    @BeforeMethod
    public void setUp() {
        admin = UserUtils.getAdminAccount();
        randomAmount = UserUtils.getRandomAmount();
        randomNumber = faker.number().numberBetween(1, 5);
    }

    @Test
    public void testVerifyThatTheDepositSuccessfullyInCaseClickOnDepositIconAtCustomersCreditCardScreen() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(admin);

        homePage.openDashboardPage();

        dashboardPage.openCustomersCreditCardManagementPage();

        customersCreditCardPage.openDepositForCustomerCreditCardPage(randomNumber);

        depositForCustomerCreditCardPage.sendMoney(randomAmount);

        // Expected Result ADM_003
        softAssert.assertTrue(depositForCustomerCreditCardPage.isTransactionCompleteTextDisplayed(), "Transaction unsuccessfully");

        // Deposit for Customer (Admin role)
        depositBalance = depositForCustomerCreditCardPage.getDepositBalance();
        transactionDate = depositForCustomerCreditCardPage.getTransactionDate();

        dashboardPage.openTransactionsCinemaManagementPage();

        // Expected Result ADM_003
        softAssert.assertEquals(transactionsCinemaPage.getTransactionTime(), transactionDate, "Deposit date and time not match");
        softAssert.assertEquals(transactionsCinemaPage.getAmountDeposit(), depositBalance, "Deposit amount not match");

        softAssert.assertAll();
    }
}
