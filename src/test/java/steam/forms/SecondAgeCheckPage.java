package steam.forms;

import framework.Utils;
import framework.elements.Label;

import static framework.BaseTest.langConf;

public class SecondAgeCheckPage extends BaseSteamPage {

    private Label lblSubmit;
    private final static String respPageIdent="responsive_page_content_overlay";
    private final static String SUB_PATTERN = "'agegate_text_container btns']//span[contains(text(),'%s";
    private final static String SUB_LOC_PATTERN = "//div[@class='agegate_text_container btns']//span[contains(text(),'%s')]";

    public SecondAgeCheckPage() {
        super(respPageIdent);
    }

    public String retSecPageIdent() {
        return String.format(SUB_PATTERN, langConf.getLangProperty("open"));
    }

    public void submitAge() {
        lblSubmit = new Label(Utils.getLocatorWithPattern(SUB_LOC_PATTERN, langConf.getLangProperty("open")));
        lblSubmit.clickElement();
    }

}
