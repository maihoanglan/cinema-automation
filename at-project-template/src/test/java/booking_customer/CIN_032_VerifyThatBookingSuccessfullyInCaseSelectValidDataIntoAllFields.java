package booking_customer;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CIN_032_VerifyThatBookingSuccessfullyInCaseSelectValidDataIntoAllFields extends TestBase {
    @BeforeMethod
    public void setUp() {
        user = UserUtils.getCustomerAccount();
    }

    @Test
    public void testVerifyThatBookingSuccessfullyInCaseSelectValidDataIntoAllFields() {
        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.quickSearchTicket("DoubleT Huế", "Tuyệt đỉnh Kung Fu", "830", "23:59:00");

        bookingInfoPage.buyTicket();

        seatSelectionPage.selectSeat();

        customerInformationPage.confirmCustomerInformation();

        paymentPage.payment("040104010401", "MAI LAN", "10", "26", "401");

        // Expected Result CIN_032
        softAssert.assertTrue(successfulTransactionPage.isSuccessNotificationDisplayed(), "Buy ticket unsuccessfully");

        softAssert.assertAll();
    }
}
