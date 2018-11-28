package steam.forms;

import framework.BaseElement;
import framework.Browser;
import framework.Utils;
import org.openqa.selenium.interactions.Actions;

public class SteamMenu {

    private final static String TAB_PATTERN = "//div[@id='%s_tab']";
    private final static String SECTION_PATTERN = "//div[@id='genre_flyout']//a[@class='popup_menu_item'][contains(text(),'%s')]";

    public void navigateMenu(String tab, String section) {
        Actions builder = new Actions(Browser.getWebDriverInstance());
        BaseElement tabEl = new BaseElement(Utils.getLocatorWithPattern(TAB_PATTERN, tab));
        builder.moveToElement(tabEl.getElement())
                .moveToElement(new BaseElement(Utils.getLocatorWithPattern(SECTION_PATTERN, section))
                        .getElement())
                .click()
                .build()
                .perform();
    }
}
