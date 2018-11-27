package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Label extends BaseElement{

    public Label(By locator) {
        super(locator);
    }
    public Label(WebElement we, By locator) {
        super(we, locator);
    }
}
