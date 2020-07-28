package test;

import browsers.WebDriverProvider;
import listeners.TestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

@Listeners({TestListener.class})
public class TestRunner {
    protected SoftAssert softAssert;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        softAssert = new SoftAssert();
        WebDriverProvider.setDriver(browser);
    }

    @AfterClass
    public void tearDown() {
        WebDriverProvider.stopWebDriver();
    }
}