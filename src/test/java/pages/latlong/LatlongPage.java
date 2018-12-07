package pages.latlong;

import pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LatlongPage extends BasePage {
    private static final String LATLONG_LINK = "https://www.latlong.net/";
    private static final By PLACE_NAME_FIELD = By.cssSelector("form input:nth-child(2)");
    private static final By LATITUDE_FIELD = By.name("lat");
    private static final By LONGITUDE_FIELD = By.name("lng");


    public LatlongPage open() {
        driver.navigate().to(LATLONG_LINK);
        return this;
    }

    @Step("Search for '{place}' place")
    public LatlongPage searchForPlace(String place) {
        getElement(PLACE_NAME_FIELD, 6).sendKeys(place);
        getElement(PLACE_NAME_FIELD).submit();
        return this;
    }

    public String getLatitude() {
        return getElement(LATITUDE_FIELD, 6).getAttribute("value");
    }

    public String getLongitude() {
        return getElement(LONGITUDE_FIELD).getAttribute("value");
    }
}
