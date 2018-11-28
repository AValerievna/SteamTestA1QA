package steam.tests;

import framework.BaseTest;
import framework.Browser;
import org.testng.annotations.Test;
import steam.forms.*;


public class TestScenario extends BaseTest {

    @Test
    public void testScenario() throws Exception {
        log.info("Go to steam");
        Browser.getPage(conf.getProperty("base.url"));
        HomeSteamPage objHomeSteamPage = new HomeSteamPage();

        log.info("Checking locale");
        objHomeSteamPage.isEngLanguage(conf.getProperty("locale"));

        log.info("Go to Actions");
        objHomeSteamPage.goToActionSteamPage();
        ActionSteamPage objActPage = new ActionSteamPage();

        log.info("Go to Specials");
        objActPage.goToSpecials();
        SpecialsPage objSpecPage = new SpecialsPage();

        log.info("Go to cheepest game");
        objSpecPage.getLargestDiscountGame();
        Double disc = objSpecPage.getNeededGame().getDiscDouble();
        Double pr = objSpecPage.getNeededGame().getPriceDouble();
        objSpecPage.goToNeededGame();

        log.info("Check price");
        GamePage objGamePage = new GamePage();
        objGamePage.isCorrectPrice(disc, pr);

        log.info("Install file");
        objGamePage.goToInstallPage();

        InstallPage objInstPage = new InstallPage();
        objInstPage.installSteam();
    }

}
