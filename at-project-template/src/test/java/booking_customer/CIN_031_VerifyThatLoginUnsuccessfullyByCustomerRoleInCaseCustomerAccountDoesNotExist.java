package booking_customer;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_031_VerifyThatLoginUnsuccessfullyByCustomerRoleInCaseCustomerAccountDoesNotExist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getRandomAccount();
    }

    @Test
    public void testVerifyThatLoginUnsuccessfullyByCustomerRoleInCaseCustomerAccountDoesNotExist() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        // Expected Result CIN_031
        softAssert.assertEquals(loginPage.getErrorMessage(), "Tài khoản hoặc mật khẩu không đúng!", "Login by customer account successfully");

        softAssert.assertAll();
    }
}
