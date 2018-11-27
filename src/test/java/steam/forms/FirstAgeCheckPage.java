package steam.forms;

import framework.BasePage;
import framework.elements.ComboBox;
import framework.elements.Label;
import org.openqa.selenium.By;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import static framework.BaseTest.conf;
import static framework.Utils.getLocatorWithPattern;

public class FirstAgeCheckPage extends BasePage {
    private ComboBox cmbDay;
    private ComboBox cmbMonth;
    private ComboBox cmbYear;
    private Label lblSubmit;
    private By submLoc = By.xpath("//div[@class='agegate_text_container btns']//span[contains(text(),'Открыть страницу')]");
    private final static String selPattern = "//select[@id='%s']";
    private final static String respPageIdent="responsive_page_content_overlay";
    private final String dayFrag = "ageDay";
    private final String monthFrag = "ageMonth";
    private final String yearFrag = "ageYear";


    public FirstAgeCheckPage() {
        super(respPageIdent);
    }

    public void inputValidData(String day,String month, String year) {
        cmbDay = new ComboBox(getLocatorWithPattern(selPattern,dayFrag));
        cmbMonth = new ComboBox(getLocatorWithPattern(selPattern,monthFrag));
        cmbYear = new ComboBox(getLocatorWithPattern(selPattern,yearFrag));
        lblSubmit = new Label(submLoc);

        cmbDay.clickOption(day);
        cmbMonth.clickOption(month);
        cmbYear.clickOption(year);

        lblSubmit.clickElement();
    }
}
