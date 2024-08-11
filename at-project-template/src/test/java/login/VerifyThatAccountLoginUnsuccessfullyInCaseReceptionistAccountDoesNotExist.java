package login;

import base.TestBase;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class VerifyThatAccountLoginUnsuccessfullyInCaseReceptionistAccountDoesNotExist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getRandomUser();
    }

    @Test
    public void TestVerifyThatAccountLoginUnsuccessfullyInCaseReceptionistAccountDoesNotExist() {
        driver.get(config.getUrlHome());
        homePage.openLoginPage();

        loginPage.login(user);
        // Expected Result REC_003
        softAssert.assertEquals(loginPage.getErrorMessage(), "Tài khoản hoặc mật khẩu không đúng!", "Login successfully");
        softAssert.assertAll();
    }
}
