package framework;

import org.openqa.selenium.By;

public class Utils {

    public static By getLocatorWithPattern(String pattern, String elemIdent) {
        return By.xpath(String.format(pattern, elemIdent));
    }
}
