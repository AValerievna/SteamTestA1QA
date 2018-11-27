package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Div extends BaseElement {
    public Div(By locator) {
        super(locator);
    }

    public Div(WebElement el, By locator) {
        super(el, locator);
    }
}
