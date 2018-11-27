package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.lang.reflect.Array;
import java.util.*;


public class BaseElement {
    private By locator;
    private WebElement baseElement;


    public By getLocator() {
        return locator;
    }

    public BaseElement(By locator) {
        this.locator = locator;
    }
    public BaseElement(WebElement el, By locator) {
        this(locator);
        this.baseElement=el;
    }


    public boolean elementExists() {
        Browser.waitElement(ExpectedConditions.presenceOfElementLocated(this.locator));
        if (baseElement == null) {
            return (Browser.getWebDriverInstance().findElements(this.locator).size() != 0);
        }  else {
            return (baseElement.findElements(this.locator).size()!=0);
        }
    }

    public WebElement getElement() {
        if (baseElement == null) {
            Browser.waitElement(ExpectedConditions.presenceOfElementLocated(this.locator));
            return (Browser.getWebDriverInstance().findElement(this.locator));
        }
        return Browser.getFluentWait(baseElement)
                .until(webElement -> webElement.findElement(locator));

    }

    public void clickElement() {
        getElement().click();
    }

    public String getElementText() {
        return getElement().getText();
    }

    public String getElementAttr(String attrName) {
        return getElement().getAttribute(attrName);
    }
}
