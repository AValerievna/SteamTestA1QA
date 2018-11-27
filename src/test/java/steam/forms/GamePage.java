package steam.forms;

import framework.BasePage;
import framework.Div;
import framework.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

import static framework.BaseTest.conf;

public class GamePage extends BasePage {
    private Div price;
    private Div discount;
    private By prLoc =By.xpath("//div[@class='game_area_purchase_game_wrapper']//div[contains(@class,\"discount_final_price\")]");
    private By discLoc=By.xpath("//div[@class='game_area_purchase_game_wrapper']//div[contains(@class,\"discount_pct\")]");
    public GamePage() {
        super(conf.getProperty("responsive.page.class.ident"));
    }


    public void isCorrectPrice(DiscountGame dg) {
        price= new Div(prLoc);
        discount= new Div(discLoc);
        Assert.assertEquals(dg.getPrice(), Utils.parseIntegerNumberFromElementText(price), "Wrong price");
        Assert.assertEquals(dg.getDiscount(),Utils.parseIntegerNumberFromElementText(discount),"Wrong discount");
    }
}
