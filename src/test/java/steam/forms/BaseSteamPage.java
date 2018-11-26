package steam.forms;

import framework.BasePage;

import static framework.BaseTest.conf;

public class BaseSteamPage extends BasePage {
    //private static final By = baseSteamPageIdent
/*    public void setLanguage() {
        Label menu = Label(By.xpath(String.format(Locale.ENGLISH)))
    }*/

    public BaseSteamPage() {
        super(conf.getProperty("base.page.class.ident"));
        System.out.println(this.ident);
    }
}
