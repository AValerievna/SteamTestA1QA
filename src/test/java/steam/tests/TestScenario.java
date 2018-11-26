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
        objBaseSteamPage.goToActionSteamPage();
        ActionSteamPage objActPage = new ActionSteamPage();

        log.info("Go to TopSellers tab");
        objActPage.goToTopSellers();

    }

}
