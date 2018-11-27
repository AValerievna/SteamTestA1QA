package framework.elements;

import framework.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Option extends BaseElement {
    public Option(By locator) {
        super(locator);
    }

    public Option(WebElement el, By locator) {
        super(el, locator);
    }
}
