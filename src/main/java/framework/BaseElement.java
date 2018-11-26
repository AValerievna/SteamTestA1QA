package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class BaseElement {
    private By locator;

    public By getLocator() {
        return locator;
    }

    public static By getLocatorWithPattern(String pattern, String elemIdent) {
        return By.xpath(String.format(pattern, elemIdent));
    }

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public boolean elementExists() {
        waitElement(ExpectedConditions.presenceOfElementLocated(this.locator));
        return (Browser.getWebDriverInstance().findElements(this.locator).size() != 0);
    }

    public  WebElement getElement() {
        waitElement(ExpectedConditions.presenceOfElementLocated(this.locator));
        return (Browser.getWebDriverInstance().findElement(this.locator));
    }

    protected  List<WebElement> getElements() {
        waitElement(ExpectedConditions.presenceOfAllElementsLocatedBy(this.locator));
        return (Browser.getWebDriverInstance().findElements(this.locator));
    }

    public void clickElement() {
        waitElement(ExpectedConditions.elementToBeClickable(this.locator));
        Browser.getWebDriverInstance().findElement(this.locator).click();
    }

    protected static <V> void waitElement(java.util.function.Function<? super WebDriver, V> isTrue) {
        Browser.getWebDriverWaitInstance().until(isTrue);
    }

    protected String getTextElement() {
        waitElement(ExpectedConditions.presenceOfElementLocated(this.locator));
        return Browser.getWebDriverInstance().findElement(this.locator).getText();
    }

    protected String getAttrElement(String attrName) {
        waitElement(ExpectedConditions.presenceOfElementLocated(this.locator));
        return Browser.getWebDriverInstance().findElement(this.locator).getAttribute(attrName);
    }
}
