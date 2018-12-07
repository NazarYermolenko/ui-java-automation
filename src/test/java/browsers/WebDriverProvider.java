package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;


public class WebDriverProvider {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private static final String HUB_URL = "http://10.128.130.208:4444/wd/hub";

    public static void setDriver(String browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setVersion("");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        switch (Browser.valueOf(browser.toUpperCase()).name()) {
            case "FIREFOX": {
                capabilities.setBrowserName("firefox");
                try {
                    threadDriver.set(new RemoteWebDriver(
                            URI.create(HUB_URL).toURL(), capabilities
                    ));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "CHROME": {
                capabilities.setBrowserName("chrome");
                try {
                    threadDriver.set(new RemoteWebDriver(
                            URI.create(HUB_URL).toURL(), capabilities
                    ));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            }
            default:
                WebDriverManager.chromedriver().forceCache().setup();
                threadDriver.set(new ChromeDriver());
                break;
        }
    }


    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static void stopWebDriver() {
        threadDriver.get().quit();
        threadDriver.remove();
    }
}