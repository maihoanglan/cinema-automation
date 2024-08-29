package deposit_admin;

import base.TestBase;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_037_VerifyThatTheDepositUnsuccessfullyInCaseTheValueInDepositBalanceIs0 extends TestBase {
    User admin;
    int randomNumber;

    @BeforeMethod
    public void setUp() {
        admin = UserUtils.getAdminAccount();
        randomNumber = faker.number().numberBetween(1, 5);
    }

    @Test
    public void testVerifyThatTheDepositUnsuccessfullyInCaseTheValueInDepositBalanceIs0() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(admin);

        homePage.openDashboardPage();

        dashboardPage.openCustomersCreditCardManagementPage();

        customersCreditCardPage.openDepositForCustomerCreditCardPage(randomNumber);

        depositForCustomerCreditCardPage.clickOnDepositButton();

        // Expected Result CIN_037
        softAssert.assertEquals(depositForCustomerCreditCardPage.getErrorMessageOfDepositBalance(), "DepositBalance must be a number greater than 0!", "Deposit successfully");

        softAssert.assertAll();
    }
}
