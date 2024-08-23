package customers_management;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class REC_019_VerifyThatUpdateCustomerAddressSuccessfullyInCaseClickOnEditIconAtCustomersManagementScreen extends TestBase {

    @BeforeMethod
    public void setUp() {
        user = UserUtils.getReceptionistAccount();
        randomAddress = faker.address().fullAddress();
        randomNumber = faker.number().numberBetween(1, 5);
    }

    @Test
    public void testVerifyThatUpdateCustomerAddressSuccessfullyInCaseClickOnEditIconAtCustomersManagementScreen() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.openAdministratorForReceptionist();

        dashboardPage.openCustomersManagementPage();

        customersManagementPage.openUpdateCustomerAddressPage(randomNumber);

        updateCustomerPage.updateCustomerAddress(randomAddress);

        // Expected Result REC_019
        softAssert.assertEquals(customersManagementPage.getCustomerAddress(randomNumber), randomAddress, "Addresses do not match");

        softAssert.assertAll();
    }
}
