package framework;


import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage {
    protected BaseElement ident;
    protected final static String identPattern="//div[@class='%s']";

    public BasePage(String pageIdent) {
        ident = getIdent(pageIdent);
        Browser.waitElement(ExpectedConditions.presenceOfElementLocated(ident.getLocator()));
    }

    private BaseElement getIdent(String pageIdent) {
        return new BaseElement(Utils.getLocatorWithPattern(identPattern, pageIdent));
    }

    protected boolean isPageOpened(String pageIdent) {
        return getIdent(pageIdent).elementExists();
    }
}
