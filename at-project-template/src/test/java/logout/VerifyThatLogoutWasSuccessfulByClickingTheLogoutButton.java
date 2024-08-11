package logout;

import base.TestBase;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class VerifyThatLogoutWasSuccessfulByClickingTheLogoutButton extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatLogoutWasSuccessfulByClickingTheLogoutButton() {
        driver.get(config.getUrlHome());
        homePage.openLoginPage();

        loginPage.login(user);
        // Login Success
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login unsuccessfully");

        homePage.logout();
        // Expected Result REC_046
        softAssert.assertTrue(homePage.isLoginButtonDisplayed(), "Logout unsuccessfully - Missing Login Button");
        softAssert.assertTrue(homePage.isRegisterButtonDisplayed(), "Logout unsuccessfully - Missing Register Button");

        softAssert.assertAll();
    }
}
