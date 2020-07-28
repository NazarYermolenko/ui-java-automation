package listeners;

import browsers.WebDriverProvider;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener extends TestListenerAdapter {
    private static final String DATE_FORMAT_PATTERN = "dd-MM-HH-mm-ss";
    private static final String SCREENSHOTS_PATH = System.getProperty("user.dir") + "/screenshots/";

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String testMethodName = iTestResult.getMethod().getMethodName();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
        String dateTime = LocalDateTime.now().format(dateTimeFormatter);

        TakesScreenshot screenshotDriver = (TakesScreenshot) WebDriverProvider.getDriver();

        File sourceFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(SCREENSHOTS_PATH + dateTime
                + " - " + testMethodName + ".png");
        try {
            FileUtils.copyFile(sourceFile, destinationFile);
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(FileUtils.readFileToByteArray(sourceFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



