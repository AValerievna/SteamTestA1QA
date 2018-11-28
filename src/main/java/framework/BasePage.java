package framework;


import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage {
    protected BaseElement ident;
    protected final static String IDENT_PATTERN = "//div[@class='%s']";

    public BasePage(String pageIdent) {
        ident = getIdent(pageIdent);
        Browser.waitElement(ExpectedConditions.presenceOfElementLocated(ident.getLocator()));
    }

    private BaseElement getIdent(String pageIdent) {
        return new BaseElement(Utils.getLocatorWithPattern(IDENT_PATTERN, pageIdent));
    }

    public boolean isPageOpened(String pageIdent) {
        return getIdent(pageIdent).elementExists();
    }
}
