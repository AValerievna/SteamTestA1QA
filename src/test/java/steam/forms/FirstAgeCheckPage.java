package steam.forms;

import framework.Utils;
import framework.elements.ComboBox;
import framework.elements.Label;

import static framework.BaseTest.langConf;
import static framework.Utils.getLocatorWithPattern;

public class FirstAgeCheckPage extends BaseSteamPage {
    private ComboBox cmbDay;
    private ComboBox cmbMonth;
    private ComboBox cmbYear;
    private Label lblSubmit;
    private final static String SUB_PATTERN = "//div[@class='agegate_text_container btns']//span[contains(text(),'%s')]";
    private final static String SEL_PATTERN = "//select[@id='%s']";
    private final static String RESP_PAGE_IDENT = "responsive_page_content_overlay";
    private final static String DAY_FRAG = "ageDay";
    private final static String MONTH_FRAG = "ageMonth";
    private final static String YEAR_FRAG = "ageYear";
    public final static String FIRST_PAGE_IDENT = "//select";


    public FirstAgeCheckPage() {
        super(RESP_PAGE_IDENT);
    }

    public void inputValidData(String day,String month, String year) {
        cmbDay = new ComboBox(getLocatorWithPattern(SEL_PATTERN, DAY_FRAG));
        cmbMonth = new ComboBox(getLocatorWithPattern(SEL_PATTERN, MONTH_FRAG));
        cmbYear = new ComboBox(getLocatorWithPattern(SEL_PATTERN, YEAR_FRAG));
        lblSubmit = new Label(Utils.getLocatorWithPattern(SUB_PATTERN, langConf.getLangProperty("open")));

        cmbDay.clickOption(day);
        cmbMonth.clickOption(month);
        cmbYear.clickOption(year);

        lblSubmit.clickElement();
    }
}
