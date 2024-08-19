package login;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_002_VerifyThatAccountLoginSuccessfullyInCaseReceptionistAccountExist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void TestVerifyThatAccountLoginSuccessfullyInCaseReceptionistAccountExist() {

        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        // Expected Result REC_002
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login by receptionist account unsuccessfully");

        softAssert.assertAll();
    }
}
