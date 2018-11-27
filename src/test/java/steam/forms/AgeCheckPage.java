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

public class AgeCheckPage extends BasePage {
    private ComboBox cmbDay;
    private ComboBox cmbMonth;
    private ComboBox cmbYear;
    private Label lblSubmit;
    private By submLoc = By.xpath("//div[@class='agegate_text_container btns']//span[contains(text(),'Открыть страницу')]");
    private final String selPattern = "//select[@id='%s']";


    public AgeCheckPage() {
        super(conf.getProperty("responsive.page.class.ident"));
    }

    public void inputValidData() {
        cmbDay = new ComboBox(getLocatorWithPattern(selPattern,conf.getProperty("day.id")));
        cmbMonth = new ComboBox(getLocatorWithPattern(selPattern,conf.getProperty("month.id")));
        cmbYear = new ComboBox(getLocatorWithPattern(selPattern,conf.getProperty("year.id")));
        lblSubmit = new Label(submLoc);

        cmbDay.clickElement();

        cmbDay.clickOption("10");
        cmbMonth.clickOption(Month.DECEMBER.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        cmbYear.clickOption("1996");

        lblSubmit.clickElement();
    }
}
