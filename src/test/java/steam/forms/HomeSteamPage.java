package steam.forms;

import framework.BasePage;
import framework.elements.Label;
import steam.enums.Tabs;

import static framework.BaseTest.conf;

public class HomeSteamPage extends BasePage {
    private SteamMenu stMenu = new SteamMenu();
    private final static String homePageIdent="home_page_content";
    private final static String langLoc ="//span[@id='language_pulldown']";
    private Label lblLang;
    //private static final By = baseSteamPageIdent


    public void setLanguage() {
        //menu = Label(By.xpath(String.format(Locale.ENGLISH)));
    }

    public HomeSteamPage() {
        super(homePageIdent);
    }

    public void goToActionSteamPage() {
        stMenu.navigateMenu(Tabs.GENRE.toString(),conf.getProperty("section.name"));
    }


}
