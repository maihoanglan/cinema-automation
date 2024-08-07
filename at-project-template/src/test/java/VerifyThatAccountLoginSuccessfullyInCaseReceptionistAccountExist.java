import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.HomePage;
import page.LoginPage;
import utils.ConfigReader;
import utils.ReadExcelFile;

import java.time.Duration;

public class VerifyThatAccountLoginSuccessfullyInCaseReceptionistAccountExist {
    WebDriver driver;
    ConfigReader config;
    ReadExcelFile readExcelFile;
    HomePage homePage;
    LoginPage loginPage;
    User user;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        config = new ConfigReader();
        readExcelFile = new ReadExcelFile("src/test/resources/users.xlsx");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        user = new User();
        user.setEmail(readExcelFile.getCell(1, 0));
        user.setPassword(readExcelFile.getCell(1, 1));
        user.setName(readExcelFile.getCell(1, 2));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VerifyLoginFromExcelFile() {
        SoftAssert softAssert = new SoftAssert();
        driver.get(config.getUrl());
        homePage.openLoginPage();

        loginPage.login(user);
        // Expected Result REC_002
        softAssert.assertEquals(homePage.getUserAccountName(), user.getName(), "Login unsuccessfully");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }
}
