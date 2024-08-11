package login;

import base.TestBase;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class VerifyThatAccountLoginSuccessfullyInCaseReceptionistAccountExist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatAccountLoginSuccessfullyInCaseReceptionistAccountExist() {
        driver.get(config.getUrlHome());
        homePage.openLoginPage();

        loginPage.login(user);
        // Expected Result REC_002
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login unsuccessfully");
        softAssert.assertAll();
    }
}
