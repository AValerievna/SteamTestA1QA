package steam.forms;

import framework.BasePage;
import framework.enums.Tabs;

import static framework.BaseTest.conf;

public class HomeSteamPage extends BasePage {
    private SteamMenu stMenu = new SteamMenu();
    //private static final By = baseSteamPageIdent
/*    public void setLanguage() {
        Label menu = Label(By.xpath(String.format(Locale.ENGLISH)))
    }*/

    public HomeSteamPage() {
        super(conf.getProperty("home.page.class.ident"));
    }

    public void goToActionSteamPage() {
        stMenu.navigateMenu(Tabs.GENRE.toString(),conf.getProperty("section.name"));
    }
}
