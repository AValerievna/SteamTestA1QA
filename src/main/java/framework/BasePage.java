package framework;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class BasePage {
    protected BaseElement ident;
    protected final static String identPattern="//div[@class='%s']";

    public BasePage(String pageIdent) {
        ident = new BaseElement(Utils.getLocatorWithPattern(identPattern, pageIdent));
        Browser.waitElement(ExpectedConditions.presenceOfElementLocated(ident.getLocator()));
        isNeededPage();
    }

    protected void isNeededPage() {
        Assert.assertTrue(this.ident.elementExists(), "Needed page did not load");
    }


}
