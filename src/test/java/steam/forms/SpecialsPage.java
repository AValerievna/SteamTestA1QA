package steam.forms;

import framework.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static framework.BaseTest.conf;

public class SpecialsPage extends BaseForm {
    List<DiscountGame> games = new ArrayList<>();
    By discGameLocator = By.xpath("//a[contains(@class, 'search_result_row')]");

    public SpecialsPage() {
        super(conf.getProperty("responsive.page.class.ident"));
    }

    public void chooseCheepest() {
        List<WebElement> webElems =new BaseElements(discGameLocator).getElements();
        for(WebElement elem : webElems) {
            games.add(new DiscountGame(elem));
            //span[contains(text(),'MONSTER HUNTER: WORLD')]
        }

    }
    public String[] getAllElementsText() {

        List<WebElement> webElems = new BaseElements(discGameLocator).getElements();
        Map<Integer, String> discounts = new TreeMap<Integer, String>();
        for(WebElement webElem : webElems) {

            discounts.add(Integer.parseInt(webElems.get(i).getText().replaceAll("\\D+","")),webElems.get(i).getText());
        }

        return discounts;
    }

}
