package steam.forms;

import framework.BasePage;
import framework.elements.ComboBox;
import framework.elements.Label;
import org.openqa.selenium.By;

import static framework.Utils.getLocatorWithPattern;

public class FirstAgeCheckPage extends BasePage {
    private ComboBox cmbDay;
    private ComboBox cmbMonth;
    private ComboBox cmbYear;
    private Label lblSubmit;
    private By submLoc = By.xpath("//div[@class='agegate_text_container btns']//span[contains(text(),'Открыть страницу')]");
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
        lblSubmit = new Label(submLoc);

        cmbDay.clickOption(day);
        cmbMonth.clickOption(month);
        cmbYear.clickOption(year);

        lblSubmit.clickElement();
    }
}
