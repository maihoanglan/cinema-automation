package general_receptionist;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class ADD_CIN_001_VerifyThatManageProfileScreenIsOpenedAfterClickingManageYourProfileButtonAtReceptionistManagementPage extends TestBase {
    String userName;
    String userEmail;

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
    }

    @Test
    public void testVerifyThatManageProfileScreenIsOpenedAfterClickingManageYourProfileButtonAtReceptionistManagementPage() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openDashboardPage();

        dashboardPage.viewUserAccount();

        // Information of receptionist at Management page
        userName = dashboardPage.getUserName();
        userEmail = dashboardPage.getUserEmail();

        dashboardPage.openManageProfilePage();

        // Expected Result ADD_CIN_001
        softAssert.assertEquals(manageUserPage.getReceptionistName(), userName, "Name not match");
        softAssert.assertEquals(manageUserPage.getReceptionistEmail(), userEmail, "Email not match");

        softAssert.assertAll();
    }
}
