package base;

import com.github.javafaker.Faker;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import page.DashboardPage;
import page.HomePage;
import page.LoginPage;
import utils.ConfigReader;
import utils.ReadExcelFile;
import utils.UserUtils;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    protected ConfigReader config;
    protected ReadExcelFile readExcelFile;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected User user;
    protected DashboardPage dashboardPage;
    protected SoftAssert softAssert;
    protected Faker faker;

    @BeforeClass
    public void navigate() {
        driver = new ChromeDriver();
        config = new ConfigReader();
        readExcelFile = new ReadExcelFile("src/test/resources/users.xlsx");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        dashboardPage = new DashboardPage(driver);
        softAssert = new SoftAssert();
        faker = new Faker();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }
}
