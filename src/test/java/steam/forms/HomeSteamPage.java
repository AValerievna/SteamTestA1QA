package steam.forms;

import framework.elements.Label;
import steam.enums.Tabs;

import static framework.BaseTest.conf;

public class HomeSteamPage extends BaseSteamPage {
    private SteamMenu stMenu = new SteamMenu();
    private final static String HOME_PAGE_IDENT = "home_page_content";
    private final static String LANG_LOC = "//span[@id='language_pulldown']";
    private Label lblLang;
    //private static final By = baseSteamPageIdent


    public void setLanguage() {
        //menu = Label(By.xpath(String.format(Locale.ENGLISH)));
    }

    public HomeSteamPage() {
        super(HOME_PAGE_IDENT);
    }

    public void goToActionSteamPage() {
        stMenu.navigateMenu(Tabs.GENRE.toString(),conf.getProperty("section.name"));
    }


}
