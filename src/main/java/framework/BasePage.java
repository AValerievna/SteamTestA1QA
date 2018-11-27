package framework;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class BasePage {
    protected BaseElement ident;
    protected final static String identPattern="//div[@class='%s']";

    public BasePage(String pageIdent) {
        if(!isPageOpened(pageIdent)){
            throw new IllegalStateException("Page did not load");
        }
    }

    protected boolean isPageOpened(String pageIdent) {
        ident = new BaseElement(Utils.getLocatorWithPattern(identPattern, pageIdent));
        Browser.waitElement(ExpectedConditions.presenceOfElementLocated(ident.getLocator()));
        return this.ident.elementExists();
    }
}
