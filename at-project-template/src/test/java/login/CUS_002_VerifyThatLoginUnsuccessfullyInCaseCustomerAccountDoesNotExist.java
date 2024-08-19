package login;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CUS_002_VerifyThatLoginUnsuccessfullyInCaseCustomerAccountDoesNotExist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getRandomAccount();
    }

    @Test
    public void testVerifyThatLoginUnsuccessfullyInCaseCustomerAccountDoesNotExist() {

        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        // Expected Result CUS_002
        softAssert.assertEquals(loginPage.getErrorMessage(), "Tài khoản hoặc mật khẩu không đúng!", "Login by customer account successfully");
        
        softAssert.assertAll();
    }
}
