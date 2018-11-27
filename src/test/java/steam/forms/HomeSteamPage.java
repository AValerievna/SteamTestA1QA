package steam.forms;

import framework.BasePage;
import steam.enums.Tabs;

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


/*    LOAD BUNDLE EXAMPLE
    ResourceBundle english = ResourceBundle.getBundle("localization", Locale.ENGLISH);
    ResourceBundle russian = ResourceBundle.getBundle("localization", Locale.forLanguageTag("ru"));

    RESOURCES FILES

    localization_en.properties
    localization_ru.properties

    THE SAME AS CONFIGURATION CLASS WITH METHOD
    public String getProperty(String propName, Locale locale) {
        return  ResourceBundle.getBundle("localization", locale).getString(propName);
    }*/
}
