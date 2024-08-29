package customers_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_015_VerifyThatCustomersManagementScreenIsOpenedByReceptionist extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatCustomersManagementScreenIsOpenedByReceptionist() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.openCustomersManagementPage();

        // Expected Result CIN_015
        softAssert.assertEquals(customersManagementPage.getTitle(), "Customers", "Customers Management screen is not displayed");

        softAssert.assertAll();
    }
}
