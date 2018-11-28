package steam.forms;

import steam.enums.Tabs;

import static framework.BaseTest.langConf;

public class HomeSteamPage extends BaseSteamPage {
    private final static String HOME_PAGE_IDENT = "home_page_content";

    public HomeSteamPage() {
        super(HOME_PAGE_IDENT);
    }

    public void goToActionSteamPage() {
        stMenu.navigateMenu(Tabs.GENRE.toString(), langConf.getLangProperty("section.name"));
    }


}
