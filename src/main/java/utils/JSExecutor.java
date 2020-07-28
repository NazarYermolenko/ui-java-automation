package utils;

import browsers.WebDriverProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JSExecutor {
    private final String HIDE_ELEMENT = "arguments[0].style.visibility='hidden'";
    private final String SCROLL_TO_BOTTOM = "window.scrollTo(0, document.body.scrollHeight)";

    private WebDriver driver;

    private JSExecutor() {
        this.driver = WebDriverProvider.getDriver();
    }

    public static JSExecutor inject() {
        return new JSExecutor();
    }


    public void hideElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(HIDE_ELEMENT, element);
    }

    public String changeElementColor(WebElement element, String color) {
        String javaScriptCode = String.format("arguments[0].style.color = '%s'", color);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(javaScriptCode, element);
        return element.getCssValue("color");
    }

    public void scrollToBottomPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(SCROLL_TO_BOTTOM);
    }


}


