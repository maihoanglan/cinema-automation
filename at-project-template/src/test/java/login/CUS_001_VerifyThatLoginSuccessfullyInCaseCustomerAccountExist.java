package login;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CUS_001_VerifyThatLoginSuccessfullyInCaseCustomerAccountExist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getCustomerAccount();
    }

    @Test
    public void testVerifyThatLoginSuccessfullyInCaseCustomerAccountExist() {

        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        // Expected Result CUS_001
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login by customer account unsuccessfully");

        softAssert.assertAll();
    }
}
