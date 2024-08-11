package login;

import base.TestBase;
import org.testng.annotations.Test;

public class VerifyThatLoginScreenIsOpenedAfterClickingOnLoginButtonAtTopRightHomePage extends TestBase {

    @Test
    public void TestVerifyThatLoginScreenIsOpenedAfterClickingOnLoginButtonAtTopRightHomePage() {
        driver.get(config.getUrlHome());
        homePage.openLoginPage();
        // Expected Result REC_001
        softAssert.assertTrue(loginPage.isEmailTextBoxDisplayed(), "Login screen not displayed - Missing Email TextBox");
        softAssert.assertTrue(loginPage.isPasswordTextBoxDisplayed(), "Login screen not displayed - Missing Password TextBox");
        softAssert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login screen not displayed - Missing Login Button");
        softAssert.assertAll();
    }
}
