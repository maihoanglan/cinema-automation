package booking_customer;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_030_VerifyThatLoginSuccessfullyByCustomerRoleInCaseCustomerAccountExists extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getCustomerAccount();
    }

    @Test
    public void testVerifyThatLoginSuccessfullyByCustomerRoleInCaseCustomerAccountExists() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        // Expected Result CIN_030
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login by customer account unsuccessfully");

        softAssert.assertAll();
    }
}
