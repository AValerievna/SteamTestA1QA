package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class BasePage {
    //protected WebDriver wd = Browser.getWebDriverInstance();

    public BasePage(By by) {
        Browser.getWebDriverWaitInstance().until(ExpectedConditions.presenceOfElementLocated(by));
        Assert.assertTrue(elementExists(by), "Needed page did not load");
    }
}
