package steam.tests;

import framework.BaseTest;
import framework.Browser;
import org.testng.annotations.Test;
import steam.forms.ActionSteamPage;
import steam.forms.GamePage;
import steam.forms.HomeSteamPage;
import steam.forms.SpecialsPage;


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

        objSpecPage.agePageExistance();

        //Browser.getPage("https://store.steampowered.com/bundle/8133/Borderlands_The_Handsome_Collection/");

        GamePage objGamePage = new GamePage();
        objGamePage.isCorrectPrice(objSpecPage.getNeededGame());

        //https://store.steampowered.com/agecheck/bundle/8133
    }

}
