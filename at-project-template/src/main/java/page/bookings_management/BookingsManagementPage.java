package page.bookings_management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.Pattern;

public class BookingsManagementPage {
    WebDriver driver;
    String result;
    By titleOfPageSelector = By.className("card-title");
    By bookingsNumberDropdownSelector = By.id("size");
    By numberOfBookingsSelector = By.xpath("//tbody//tr");
    By searchBoxSelector = By.id("searchValue");
    By searchButtonSelector = By.xpath("//div[@id='order-listing_filter']//button");
    By nameOfMovieSelector = By.xpath("//tbody//tr//td[2]//p[2]//span");
    By textMessageSelector = By.xpath("//tbody//div//h5");
    By viewBookingDetailsSelector = By.xpath("//tbody//tr//td[2]//p[3]//a");
    By viewInvoiceOfThisBookingSelector = By.xpath("//tbody//tr//td[2]//p[4]//a");

    public BookingsManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(titleOfPageSelector).getText();
    }

    private void selectNumberOfBookings(String rows) {
        WebElement bookingsNumber = driver.findElement(bookingsNumberDropdownSelector);
        bookingsNumber.click();
        Select select = new Select(bookingsNumber);
        select.selectByVisibleText(rows);
    }

    public void showFiveBookingRows() {
        selectNumberOfBookings("5");
    }

    public void showTenBookingRows() {
        selectNumberOfBookings("10");
    }

    public void showFifteenBookingRows() {
        selectNumberOfBookings("15");
    }

    public int numberOfBookingsIsDisplay() {
        List<WebElement> numberOfBookings = driver.findElements(numberOfBookingsSelector);
        int rowBookings;
        return rowBookings = numberOfBookings.size();
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButtonSelector).click();
    }

    public void search(String movieName) {
        WebElement searchBox = driver.findElement(searchBoxSelector);
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(movieName);
        clickOnSearchButton();
    }


    public String getMovieNameOfFirstRow() {
        String exactlyOfMovieName = driver.findElement(nameOfMovieSelector).getText();
        if (exactlyOfMovieName.contains(".")) {
            result = Pattern.compile("\\.").matcher(exactlyOfMovieName).replaceAll("");
        } else {
            result = driver.findElement(nameOfMovieSelector).getText();
        }
        return result;
    }

    public boolean areAllMovieNameContains(String movieName) {
        List<WebElement> resultMovies = driver.findElements(nameOfMovieSelector);
        boolean foundExactMatch = false;
        for (WebElement result : resultMovies) {
            if (result.getText().contains(movieName)) {
                foundExactMatch = true;
                break;
            }
        }
        return foundExactMatch;
    }

    public boolean isNoResultDisplayed() {
        return driver.findElement(textMessageSelector).isDisplayed();
    }

    public void openViewBookingDetailsPage() {
        driver.findElement(viewBookingDetailsSelector).click();
    }

    public void openViewInvoiceOfThisBookingPage() {
        driver.findElement(viewInvoiceOfThisBookingSelector).click();
    }
}
