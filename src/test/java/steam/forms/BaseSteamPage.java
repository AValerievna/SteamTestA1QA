package steam.forms;

import framework.BaseForm;

import static framework.BaseTest.conf;

public class BaseSteamPage extends BaseForm {
    private SteamMenu stMenu = new SteamMenu();
    //private static final By = baseSteamPageIdent
/*    public void setLanguage() {
        Label menu = Label(By.xpath(String.format(Locale.ENGLISH)))
    }*/

    public BaseSteamPage() {
        super(conf.getProperty("base.page.class.ident"));
    }

    public void goToActionSteamPage() {
        stMenu.navigateMenu(conf.getProperty("tab.id"),conf.getProperty("section.name"));
    }
}
