package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonFunctions {

    public static By getLocatorWithPattern(String pattern, String elemIdent) {
        return By.xpath(String.format(pattern, elemIdent));
    }

}
