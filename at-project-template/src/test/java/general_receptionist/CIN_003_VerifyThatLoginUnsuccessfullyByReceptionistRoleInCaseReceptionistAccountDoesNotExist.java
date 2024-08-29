package general_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_003_VerifyThatLoginUnsuccessfullyByReceptionistRoleInCaseReceptionistAccountDoesNotExist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getRandomAccount();
    }

    @Test
    public void testVerifyThatLoginUnsuccessfullyByReceptionistRoleInCaseReceptionistAccountDoesNotExist() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        // Expected Result CIN_003
        softAssert.assertEquals(loginPage.getErrorMessage(), "Tài khoản hoặc mật khẩu không đúng!", "Login by receptionist account successfully");

        softAssert.assertAll();
    }
}
