package steam.forms;

import framework.BasePage;
import framework.Utils;
import framework.elements.Label;

public class ActionSteamPage extends BasePage {
    private final static String LBL_PATTERN = "//div[@class='%s']//a";
    private final static String RESP_PAGE_IDENT = "responsive_page_content_overlay";
    private final static String SPECIALS_LABEL_FRAGMENT = "contenthub_specials_see_more";
    private Label lblSpecials;

    public ActionSteamPage() {
        super(RESP_PAGE_IDENT);
    }

    public void goToSpecials() {
        lblSpecials = new Label(Utils.getLocatorWithPattern(LBL_PATTERN, SPECIALS_LABEL_FRAGMENT));
        lblSpecials.clickElement();
    }

}
