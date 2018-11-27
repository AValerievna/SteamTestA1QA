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

        log.info("Go to Actions");
        objHomeSteamPage.goToActionSteamPage();
        ActionSteamPage objActPage = new ActionSteamPage();

        log.info("Go to Specials");
        objActPage.goToSpecials();
        SpecialsPage objSpecPage = new SpecialsPage();

        log.info("Go to cheepest game");
        objSpecPage.goToLargestDiscount();
        GamePage objGamePage = new GamePage();
        objGamePage.isCorrectPrice(objSpecPage.getNeededGame());

        AgeCheckPage objAgeCheck= new AgeCheckPage();
        objAgeCheck.inputValidData();

        //https://store.steampowered.com/agecheck/bundle/8133
    }

}
