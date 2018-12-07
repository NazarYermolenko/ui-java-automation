package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends HeaderBar {
    private static final By SEARCH_RESULT_LINK = By.cssSelector(".r a");


    public WebElement getLinkByNumber(int numberOfLink) {
        return getElements(SEARCH_RESULT_LINK).get(numberOfLink - 1);
    }

    public String getLinkTextByNumber(int numberOfLink) {
        return getLinkByNumber(numberOfLink).getText();
    }
}