package booking;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserUtils;

public class VerifyThatTheCustomerWillMakeASuccessfulBookingInCaseTicketPurchaseSuccessful extends TestBase {
    @BeforeMethod
    public void setUp() {
        user = UserUtils.getUser();
    }

    @Test
    public void TestVerifyThatTheCustomerWillMakeASuccessfulBookingInCaseTicketPurchaseSuccessful() {
        driver.get(config.getUrlHome());
        homePage.openLoginPage();

        loginPage.login(user);
        // Login Success
        softAssert.assertEquals(homePage.getEmailName(), user.getEmail(), "Login unsuccessfully");

        homePage.buyTicket();
        // 'THONG TIN DAT VE' page is displayed
        softAssert.assertEquals(bookingInfoPage.getTitleBookingInfoPage(), "THÔNG TIN ĐẶT VÉ", "THONG TIN DAT VE page is not displayed");

        bookingInfoPage.order();
        // 'CHON GHE' page is dispalyed
        softAssert.assertEquals(seatSelectionPage.getTitleSeatSelectionPage(), "CHỌN GHẾ", "CHON GHE page is not displayed");

        seatSelectionPage.selectSeat();

        softAssert.assertAll();
    }
}
