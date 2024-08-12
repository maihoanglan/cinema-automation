package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BookingManagementPage {
    WebDriver driver;
    By titleOfPageSelector = By.className("card-title");
    By bookingsNumberDropdownSelector = By.id("size");
    By bookingsDataTableSelector = By.xpath("//tbody");
    By numberOfBookingsSelector = By.xpath("//tbody//tr");
    By searchBoxSelector = By.xpath("//div[@class='dataTables_filter']//input");
    By searchButtonSelector = By.xpath("//div[@id='order-listing_filter']//button");
    By nameOfMovieSelector = By.xpath("//tbody//tr//td[2]//p[2]//span");
    By textMessageSelector = By.xpath("//h5[text()='No data displayed ! Please check again !']");
    By viewBookingDetailsSelector = By.xpath("//tbody//tr//td[2]//p[3]//a");
    By viewInvoiceOfThisBookingSelector = By.xpath("//tbody//tr//td[2]//p[4]//a");


    public BookingManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleBookingManagementPage() {
        return driver.findElement(titleOfPageSelector).getText();
    }

    public void showFiveBookingRows() {
        WebElement bookingsNumber = driver.findElement(bookingsNumberDropdownSelector);
        bookingsNumber.click();
        Select select = new Select(bookingsNumber);
        select.selectByVisibleText("5");
    }

    public void showTenBookingRows() {
        WebElement bookingsNumber = driver.findElement(bookingsNumberDropdownSelector);
        bookingsNumber.click();
        Select select = new Select(bookingsNumber);
        select.selectByVisibleText("10");
    }

    public void showFifteenBookingRows() {
        WebElement bookingsNumber = driver.findElement(bookingsNumberDropdownSelector);
        bookingsNumber.click();
        Select select = new Select(bookingsNumber);
        select.selectByVisibleText("15");
    }

    public int numberOfBookingsIsDisplay() {
        WebElement bookingsDataTable = driver.findElement(bookingsDataTableSelector);
        List<WebElement> numberOfBookings = bookingsDataTable.findElements(numberOfBookingsSelector);
        int rowBookings;
        return rowBookings = numberOfBookings.size();
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButtonSelector).click();
    }

    public boolean searchForExactly() {
        WebElement searchExactly = driver.findElement(searchBoxSelector);
        searchExactly.click();
        searchExactly.clear();
        searchExactly.sendKeys("Kung Fu Hustle");
        clickOnSearchButton();

        // Verify search results
        WebElement searchResults = driver.findElement(numberOfBookingsSelector);
        List<WebElement> resultMovies = searchResults.findElements(nameOfMovieSelector);

        boolean foundExactMatch = false;
        for (WebElement result : resultMovies) {
            if (result.getText().equals("Kung Fu Hustle")) {
                foundExactMatch = true;
                break;
            }
        }
        return foundExactMatch;
    }

    public boolean searchForPartially() {
        WebElement searchExactly = driver.findElement(searchBoxSelector);
        searchExactly.click();
        searchExactly.clear();
        searchExactly.sendKeys("Hus");
        clickOnSearchButton();

        // Verify search results
        WebElement searchResults = driver.findElement(numberOfBookingsSelector);
        List<WebElement> resultMovies = searchResults.findElements(nameOfMovieSelector);

        boolean foundPartialMatch = false;
        for (WebElement result : resultMovies) {
            if (result.getText().equals("Kung Fu Hustle")) {
                foundPartialMatch = true;
                break;
            }
        }
        return foundPartialMatch;
    }

    public void searchForNoResults() {
        WebElement searchExactly = driver.findElement(searchBoxSelector);
        searchExactly.click();
        searchExactly.clear();
        searchExactly.sendKeys("KungFuHustle");
        clickOnSearchButton();
    }

    public String verifySearchForNoResults() {
        return driver.findElement(textMessageSelector).getText();
    }

    public void openViewBookingDetailsPage() {
        driver.findElement(viewBookingDetailsSelector).click();
    }

    public void openViewInvoiceOfThisBookingPage() {
        driver.findElement(viewInvoiceOfThisBookingSelector).click();
    }
}
