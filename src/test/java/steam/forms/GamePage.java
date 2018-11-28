package steam.forms;

import framework.Utils;
import framework.elements.Div;
import org.openqa.selenium.By;
import org.testng.Assert;

import static framework.BaseTest.conf;

public class GamePage extends BaseSteamPage {
    private Div price;
    private Div discount;
    private By prLoc = By.xpath("//div[contains(@class,\"game_area_purchase_game\")]//div[contains(@class,\"discount_final_price\")]");
    //div[contains(@class,"game_area_purchase_game bundle")]//div[contains(@class,"discount_final_price")][1]
    private By discLoc = By.xpath("//div[@class='game_purchase_action_bg']//div[contains(@class, \"discount_pct\")][1]");
    private final static String SEL_PATTERN = "//select";
    private final static String SEC_PAGE_PATTERN = "//select[@id='%s']";

    public GamePage() {
        super(conf.getProperty("responsive.page.class.ident"));
    }


    public void isCorrectPrice(Double disc, Double pr) {
        price= new Div(prLoc);
        discount= new Div(discLoc);
        Assert.assertEquals(pr, Utils
                .parseDoubleNumberFromElementText(price), "Wrong price");
        Assert.assertEquals(disc,
                Utils.parseDoubleNumberFromElementText(discount),"Wrong discount");
    }
}
