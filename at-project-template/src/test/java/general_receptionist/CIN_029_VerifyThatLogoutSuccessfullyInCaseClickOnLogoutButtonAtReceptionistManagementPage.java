package general_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_029_VerifyThatLogoutSuccessfullyInCaseClickOnLogoutButtonAtReceptionistManagementPage extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatLogoutSuccessfullyInCaseClickOnLogoutButtonAtReceptionistManagementPage() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.logout();

        // Expected Result CIN_029
        softAssert.assertTrue(homePage.isLoginButtonDisplayed(), "Logout unsuccessfully - Missing Login Button");
        softAssert.assertTrue(homePage.isRegisterButtonDisplayed(), "Logout unsuccessfully - Missing Register Button");

        softAssert.assertAll();
    }
}
