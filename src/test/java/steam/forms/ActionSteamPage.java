package steam.forms;

import framework.*;
import org.openqa.selenium.By;

import java.util.List;

import static framework.BaseTest.conf;

public class ActionSteamPage extends BasePage {
    private final static String lblPattern = "//div[@class='%s']//a";
    //By discGame = By.xpath("//div[@class='discount_block tab_item_discount'/..");
    private Label specialsLabel;

    public ActionSteamPage() {
        super(conf.getProperty("responsive.page.class.ident"));
    }

    public void goToSpecials() {
        specialsLabel = new Label(Utils.getLocatorWithPattern(lblPattern,conf.getProperty("specials.label")));
        specialsLabel.clickElement();
    }

}
