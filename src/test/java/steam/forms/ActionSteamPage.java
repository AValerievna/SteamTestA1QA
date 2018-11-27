package steam.forms;

import framework.*;
import framework.elements.Label;

public class ActionSteamPage extends BasePage {
    private final static String lblPattern = "//div[@class='%s']//a";
    private final static String respPageIdent="responsive_page_content_overlay";
    private final static String specialsLabelFragment="contenthub_specials_see_more";
    private Label lblSpecials;

    public ActionSteamPage() {
        super(respPageIdent);
    }

    public void goToSpecials() {
        lblSpecials = new Label(Utils.getLocatorWithPattern(lblPattern,specialsLabelFragment));
        lblSpecials.clickElement();
    }

}
