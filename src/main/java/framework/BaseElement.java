package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BaseElement {
    protected boolean elementExists(By by) {
        waitElement(ExpectedConditions.presenceOfElementLocated(by));

        // REALLY?
        return (Browser.getWebDriverInstance().findElements(by).size() != 0);
    }

    protected WebElement getElement(By by) {
        waitElement(ExpectedConditions.presenceOfElementLocated(by));

        // REALLY?
        return (Browser.getWebDriverInstance().findElement(by));
    }

    protected List<WebElement> getElements(By by) {
        waitElement(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

        // REALLY?
        return (Browser.getWebDriverInstance().findElements(by));
    }

    protected void clickElement(By by) {
        waitElement(ExpectedConditions.elementToBeClickable(by));

        // REALLY?
        Browser.getWebDriverInstance().findElement(by).click();
    }

    //HOW???
    protected <V> void waitElement(java.util.function.Function<? super WebDriver,V> isTrue) {
        Browser.getWebDriverWaitInstance().until(isTrue);
    }

    protected String getTextElement(By by) {
        waitElement(ExpectedConditions.presenceOfElementLocated(by));

        // REALLY?
        return Browser.getWebDriverInstance().findElement(by).getText();
    }

    protected String getAttrElement(By by, String attrName) {
        waitElement(ExpectedConditions.presenceOfElementLocated(by));

        // REALLY?
        return Browser.getWebDriverInstance().findElement(by).getAttribute(attrName);
    }
}
