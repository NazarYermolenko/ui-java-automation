package pages.google;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BasePage;

public abstract class HeaderBar extends BasePage {
    private static final By IMAGES_PAGE_LINK = By.xpath("(//a[@class='q qs'])[1]");
    private static final By HEADER_LOGO = By.id("logo");
    private static final By NEW_HEADER_LOGO = By.cssSelector("#logocont a");


    @Step("Navigate to Home Page")
    public HomePage navigateToHomePage() {
        getElement(NEW_HEADER_LOGO).click();
        return new HomePage();
    }

    @Step("Navigate to Images Page")
    public ImagesPage navigateToImagesPage() {
        getElement(IMAGES_PAGE_LINK).click();
        return new ImagesPage();
    }
}