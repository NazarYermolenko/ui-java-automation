package pages;

import browsers.WebDriverProvider;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class BasePage {
    private static final int DEFAULT_TIMEOUT = 5;
    private static final String SCREENSHOTS_PATH = System.getProperty("user.dir") + "/screenshots/";
    private static final String DATE_FORMAT_PATTERN = "dd-MM-HH-mm-ss";

    protected WebDriver driver;

    protected BasePage() {
        this.driver = WebDriverProvider.getDriver();
    }

    protected WebElement getElement(By locator, int... timeInSeconds) {
        return new WebDriverWait(driver, getTimeOut(timeInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> getElements(By locator, int... timeInSeconds) {
        return new WebDriverWait(driver, getTimeOut(timeInSeconds))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected List<WebElement> getPresentElements(By locator, int... timeInSeconds) {
        return new WebDriverWait(driver, getTimeOut(timeInSeconds))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    @Step("Take Screen Shot")
    public void takeScreenShot() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
        String dateTime = LocalDateTime.now().format(dateTimeFormatter);

        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(SCREENSHOTS_PATH + dateTime + ".png");
        try {
            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getTimeOut(int... timeInSeconds) {
        return (timeInSeconds.length == 0) ? DEFAULT_TIMEOUT : timeInSeconds[0];
    }
}