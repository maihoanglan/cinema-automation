package login;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_003_VerifyThatAccountLoginUnsuccessfullyInCaseReceptionistAccountDoesNotExist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getRandomAccount();
    }

    @Test
    public void TestVerifyThatAccountLoginUnsuccessfullyInCaseReceptionistAccountDoesNotExist() {

        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        // Expected Result REC_003
        softAssert.assertEquals(loginPage.getErrorMessage(), "Tài khoản hoặc mật khẩu không đúng!", "Login by receptionist account successfully");
        
        softAssert.assertAll();
    }
}
