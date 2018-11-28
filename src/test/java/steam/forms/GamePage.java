package steam.forms;

import framework.BasePage;
import framework.Utils;
import framework.elements.Div;
import org.openqa.selenium.By;
import org.testng.Assert;

import static framework.BaseTest.conf;

public class GamePage extends BasePage {
    private Div price;
    private Div discount;
    private By prLoc = By.xpath("//div[contains(@class,\"game_area_purchase_game\")]//div[contains(@class,\"discount_final_price\")]");
    //div[contains(@class,"game_area_purchase_game bundle")]//div[contains(@class,"discount_final_price")][1]
    private By discLoc = By.xpath("//div[@class='game_area_purchase_game_wrapper']//div[@class='discount_pct')]");
    private final static String SEL_PATTERN = "//select";
    private final static String SEC_PAGE_PATTERN = "//select[@id='%s']";

    public GamePage() {
        super(conf.getProperty("responsive.page.class.ident"));
    }


    public void isCorrectPrice(DiscountGame dg) {
        price= new Div(prLoc);
        discount= new Div(discLoc);
        Assert.assertEquals(dg.getPriceDouble(),
                Utils.parseDoubleNumberFromElementText(price), "Wrong price");
        Assert.assertEquals(dg.getDiscDouble(),
                Utils.parseDoubleNumberFromElementText(discount),"Wrong discount");
    }
}
