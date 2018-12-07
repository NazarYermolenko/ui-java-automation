package test;


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.google.HomePage;
import pages.google.ImagesPage;
import pages.google.SearchResultPage;
import utils.JSExecutor;



@Feature("Google search test")
public class GoogleTest extends TestRunner {

    private SearchResultPage searchResultPage;
    private ImagesPage imagesPage;
    private HomePage homePage;

    @Test()
    @Description("Google test")
    public void googleTest() {
        homePage = new HomePage().open();

        String searchText = "funny picture";
        searchResultPage = homePage.searchFor(searchText);
        String resultLinkText = searchResultPage.getLinkTextByNumber(1).trim().toLowerCase();
        softAssert.assertTrue(resultLinkText.contains(searchText));

        imagesPage = searchResultPage.navigateToImagesPage();
        long resultImagesCount = imagesPage.getResultImages().stream()
                .filter(element -> element.isDisplayed()).count();
        long expectedResultsImagesCount = 5;
        softAssert.assertTrue(resultImagesCount > expectedResultsImagesCount);

        imagesPage.navigateToHomePage();
        boolean isLogoDisplayed = homePage.isLogoDisplayed();
        softAssert.assertTrue(isLogoDisplayed);

        JSExecutor.inject().hideElement(homePage.getMainLogo());
        isLogoDisplayed = homePage.isLogoDisplayed();
        softAssert.assertFalse(isLogoDisplayed);

        searchText = "funny kittens";
        searchResultPage = homePage.searchFor(searchText);
        resultLinkText = searchResultPage
                .getLinkTextByNumber(1).trim().toLowerCase();
        softAssert.assertTrue(resultLinkText.contains(searchText));

        String changedLinkColor = "rgba(255, 255, 171, 1)";
        String newLinkColor = JSExecutor.inject()
                .changeElementColor(searchResultPage.getLinkByNumber(1), changedLinkColor);
        softAssert.assertEquals(newLinkColor, changedLinkColor);

        JSExecutor.inject().scrollToBottomPage();
        searchResultPage.takeScreenShot();

        softAssert.assertAll();
    }


}
