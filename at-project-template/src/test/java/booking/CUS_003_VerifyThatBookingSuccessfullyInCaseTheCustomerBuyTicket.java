package booking;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class CUS_003_VerifyThatBookingSuccessfullyInCaseTheCustomerBuyTicket extends TestBase {
    @BeforeMethod
    public void setUp() {
        user = UserUtils.getCustomerAccount();
    }

    @Test
    public void testVerifyThatBookingSuccessfullyInCaseTheCustomerBuyTicket() {

        driver.get(config.getUrlHome());

        homePage.openLoginPage();

        loginPage.login(user);

        homePage.quickSearchTicket("DoubleT Huế", "Tuyệt đỉnh Kung Fu", "23:59:00");
        bookingInfoPage.buyTicket();
        seatSelectionPage.selectSeat();

        customerInformationPage.confirmCustomerInformation();
        paymentPage.payment("040104010401", "MAI LAN", "10", "26", "401");

        // Expected Result CUS_003
        softAssert.assertTrue(successfulTransactionPage.isSuccessNotificationDisplayed(), "Buy ticket unsuccessfully");

        softAssert.assertAll();
    }
}
