package deposit_admin;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_033_VerifyThatLoginSuccessfullyByAdminRoleInCaseAdminAccountExists extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getAdminAccount();
    }

    @Test
    public void testVerifyThatLoginSuccessfullyByAdminRoleInCaseAdminAccountExists() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        // Expected Result CIN_033
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login by admin account unsuccessfully");

        softAssert.assertAll();
    }
}
