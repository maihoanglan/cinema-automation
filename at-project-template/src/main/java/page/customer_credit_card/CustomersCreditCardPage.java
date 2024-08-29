package page.customer_credit_card;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomersCreditCardPage {
    WebDriver driver;

    public CustomersCreditCardPage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickOnDepositIcon(int row) {
        driver.findElement(By.xpath(String.format("//tbody/tr[%s]/td/a", row))).click();
    }

    public void openDepositForCustomerCreditCardPage(int row) {
        clickOnDepositIcon(row);
        // Interact with elements of new tab
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }
}
