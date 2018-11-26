package steam.forms;

import framework.BaseElement;
import framework.Browser;
import org.openqa.selenium.interactions.Actions;

public class SteamMenu {

    private final static String tabPattern = "//div[@id='%s']";
    private final static String sectionPattern = "//div[@id='genre_flyout']//a[@class='popup_menu_item'][contains(text(),'%s')]";

    public void navigateMenu(String tab, String section) {
        Actions builder = new Actions(Browser.getWebDriverInstance());
        BaseElement tabEl = new BaseElement(BaseElement.getLocatorWithPattern(tabPattern, tab));
        builder.moveToElement(tabEl.getElement())
                .moveToElement(new BaseElement(BaseElement.getLocatorWithPattern(sectionPattern, section))
                        .getElement())
                .click()
                .build()
                .perform();
        //BaseElement secEl = new BaseElement(BaseElement.getLocatorWithPattern(sectionPattern, section));
        //builder.click(secEl.getElement());
        //secEl.clickElement();
    }
}
