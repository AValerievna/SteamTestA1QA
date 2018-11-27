package steam.forms;

import framework.BaseElements;
import framework.BasePage;
import framework.Browser;
import framework.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
    public void goToLargestDiscount() {
        getDiscountGames();
        Browser.getFluentWait().until();
        getGame().getElement().click();
    }

    private Label getGame() {
        return games.stream().max(Comparator.comparing(DiscountGame::getDiscount))
                .orElse(null)
                .getGame();
    }

}
