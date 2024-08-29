package deposit_admin;

import base.TestBase;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_036_VerifyThatTheDefaultValueIsDisplayedOnDepositBalanceFieldAtDepositForCustomerCreditCardScreen extends TestBase {
    User admin;
    int randomNumber;

    @BeforeMethod
    public void setUp() {
        admin = UserUtils.getAdminAccount();
        randomNumber = faker.number().numberBetween(1, 5);
    }

    @Test
    public void testVerifyThatTheDefaultValueIsDisplayedOnDepositBalanceFieldAtDepositForCustomerCreditCardScreen() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(admin);

        homePage.openDashboardPage();

        dashboardPage.openCustomersCreditCardManagementPage();

        customersCreditCardPage.openDepositForCustomerCreditCardPage(randomNumber);

        // Expected Result CIN_036
        softAssert.assertEquals(depositForCustomerCreditCardPage.getDefaultValueOfDepositBalance(), 0, "Default value not match");

        softAssert.assertAll();
    }
}
