package steam.forms;

import framework.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

import static framework.BaseTest.conf;

public class SpecialsPage extends BasePage {
    List<DiscountGame> games = new ArrayList<>();
    By discGameLocator = By.xpath("//a[contains(@class, 'search_result_row')]");

    public SpecialsPage() {
        super(conf.getProperty("responsive.page.class.ident"));
    }

    public void getDiscountGames() {
        List<WebElement> webElems =new BaseElements(discGameLocator).getElements();
        for(WebElement elem : webElems) {
            games.add(new DiscountGame(elem));
        }
    }
    public void goToCheepest() {
        games.stream().sorted(Comparator.comparing(DiscountGame::getDiscount).reversed())
                .findFirst()
                .orElse(null)
                .getGame()
                .clickElement();
    }

}
