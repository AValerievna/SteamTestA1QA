package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BaseElements {

    private By locator;

    public BaseElements(By locator) {
        this.locator = locator;
    }

    public List<WebElement> getElements() {
        Browser.waitElement(ExpectedConditions.presenceOfAllElementsLocatedBy(this.locator));
        return Browser.getWebDriverInstance().findElements(this.locator);
    }
}
