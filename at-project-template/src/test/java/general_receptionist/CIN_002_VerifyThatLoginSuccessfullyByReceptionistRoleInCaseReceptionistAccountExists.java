package general_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_002_VerifyThatLoginSuccessfullyByReceptionistRoleInCaseReceptionistAccountExists extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatLoginSuccessfullyByReceptionistRoleInCaseReceptionistAccountExists() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        // Expected Result CIN_002
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login by receptionist account unsuccessfully");

        softAssert.assertAll();
    }
}
