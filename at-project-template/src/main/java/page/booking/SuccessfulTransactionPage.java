package page.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulTransactionPage {
    WebDriver driver;
    By successNotificationSelector = By.xpath("//p[starts-with(text(),'Chúc mừng bạn, bạn đã mua vé thành công')]");

    public SuccessfulTransactionPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSuccessNotificationDisplayed() {
        return driver.findElement(successNotificationSelector).isDisplayed();
    }
}
