package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.Array;
import java.util.*;


public class BaseElement {
    private By locator;

    public By getLocator() {
        return locator;
    }

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public boolean elementExists() {
        Browser.waitElement(ExpectedConditions.presenceOfElementLocated(this.locator));
        return (Browser.getWebDriverInstance().findElements(this.locator).size() != 0);
    }

    public WebElement getElement() {
        Browser.waitElement(ExpectedConditions.presenceOfElementLocated(this.locator));
        return (Browser.getWebDriverInstance().findElement(this.locator));
    }

    public void clickElement() {
        Browser.waitElement(ExpectedConditions.elementToBeClickable(this.locator));
        Browser.getWebDriverInstance().findElement(this.locator).click();
    }

    protected String getTextElement() {
        Browser.waitElement(ExpectedConditions.presenceOfElementLocated(this.locator));
        return Browser.getWebDriverInstance().findElement(this.locator).getText();
    }

    protected String getAttrElement(String attrName) {
        Browser.waitElement(ExpectedConditions.presenceOfElementLocated(this.locator));
        return Browser.getWebDriverInstance().findElement(this.locator).getAttribute(attrName);
    }
}
