package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BaseElements {

    private By locator;
    private WebElement baseElement;

    public BaseElements(By locator) {
        this.locator = locator;
    }
    public BaseElements(WebElement el, By locator) {
        this(locator);
        this.baseElement = el;
    }

    public List<WebElement> getElements() {
        if (baseElement == null) {
            Browser.waitElement(ExpectedConditions.presenceOfAllElementsLocatedBy(this.locator));
            return Browser.getWebDriverInstance().findElements(this.locator);
        }
        return Browser.getFluentWait(baseElement)
                .until(webElement -> webElement.findElements(locator));
    }
}
