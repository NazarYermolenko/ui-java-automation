package pages.google;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class HomePage extends BasePage {
    private static final String GOOGLE_LINK = "https://google.com";

    private static final By MAIN_LOGO = By.id("hplogo");
    private static final By SEARCH_FIELD = By.id("lst-ib");


    @Step("Open Google home page")
    public HomePage open() {
        driver.navigate().to(GOOGLE_LINK);
        return new HomePage();
    }

    @Step("Search for '{text}' text")
    public SearchResultPage searchFor(String text) {
        getElement(SEARCH_FIELD).sendKeys(text);
        getElement(SEARCH_FIELD).submit();
        return new SearchResultPage();
    }

    public boolean isLogoDisplayed() {
        return isElementDisplayed(MAIN_LOGO);
    }

    public WebElement getMainLogo() {
        return getElement(MAIN_LOGO);
    }
}