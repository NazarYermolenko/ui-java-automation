package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ImagesPage extends HeaderBar {
    private static final By RESULT_IMAGES = By.cssSelector("div#rg_s img");


    public List<WebElement> getResultImages() {
        return getPresentElements(RESULT_IMAGES, 5);
    }
}