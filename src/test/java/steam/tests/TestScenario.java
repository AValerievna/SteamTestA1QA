package steam.tests;

import framework.BaseTest;
import framework.Browser;
import org.testng.annotations.Test;
import steam.forms.BaseSteamPage;
import steam.forms.SteamMenu;


public class TestScenario extends BaseTest {

    @Test
    public void testScenario() throws Exception {
        log.info("Go to steam");
        Browser.getPage(conf.getProperty("base.url"));
        BaseSteamPage objBaseSteamPage = new BaseSteamPage();

        log.info("Go to Actions");
        SteamMenu stMenu = new SteamMenu();
        stMenu.navigateMenu(conf.getProperty("tab.id"),conf.getProperty("section.name"));
        /*objHomePage.clickLogin();
        UtilityMethods.redirectionToLoginPage(conf.getProperty("url.login.page.fragment"));
        LoginPage objLoginPage = new LoginPage();*/
    }

}
