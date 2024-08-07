import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.HomePage;
import page.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class VerifyThatLoginScreenIsOpenedAfterClickingOnLoginButtonAtTopRightHomePage {
    WebDriver driver;
    ConfigReader config;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        config = new ConfigReader();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TestVerifyThatLoginScreenIsOpenedAfterClickingOnLoginButtonAtTopRightHomePage() {
        SoftAssert softAssert = new SoftAssert();
        driver.get(config.getUrl());
        homePage.openLoginPage();
        // Expected Result REC_001
        softAssert.assertTrue(loginPage.isEmailTextBoxDisplayed(), "Login screen not displayed - Missing Email TextBox");
        softAssert.assertTrue(loginPage.isPasswordTextBoxDisplayed(), "Login screen not displayed - Missing Password TextBox");
        softAssert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login screen not displayed - Missing Login Button");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }
}
