package framework.elements;

import framework.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Span extends BaseElement {
    public Span(By locator) {
        super(locator);
    }
    public Span(WebElement el, By locator) {
        super(el, locator);
    }
}
