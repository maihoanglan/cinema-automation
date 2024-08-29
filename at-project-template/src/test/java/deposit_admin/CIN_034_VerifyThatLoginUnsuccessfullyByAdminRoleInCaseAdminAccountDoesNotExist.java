package deposit_admin;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_034_VerifyThatLoginUnsuccessfullyByAdminRoleInCaseAdminAccountDoesNotExist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getRandomAccount();
    }

    @Test
    public void testVerifyThatLoginUnsuccessfullyByAdminRoleInCaseAdminAccountDoesNotExist() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        // Expected Result CIN_034
        softAssert.assertEquals(loginPage.getErrorMessage(), "Tài khoản hoặc mật khẩu không đúng!", "Login by admin account successfully");

        softAssert.assertAll();
    }
}
