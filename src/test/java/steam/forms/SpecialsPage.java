package steam.forms;

import framework.BaseElements;
import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static framework.BaseTest.conf;

public class SpecialsPage extends BasePage {
    List<DiscountGame> games = new ArrayList<>();
    DiscountGame neededGame;
    By discGameLocator = By.xpath("//a[contains(@class, 'search_result_row')]");
    private final static String respPageIdent="responsive_page_content_overlay";


    public SpecialsPage() {
        super(respPageIdent);
    }

    public void getDiscountGames() {
        List<WebElement> webElems =new BaseElements(discGameLocator).getElements();
        for(WebElement elem : webElems) {
            games.add(new DiscountGame(elem));
        }
    }
    public void goToLargestDiscount() {
        getDiscountGames();
        neededGame= getGame();
        neededGame.getGameLabel().clickElement();
    }

    public DiscountGame getNeededGame() {
        return neededGame;
    }
    DiscountGame getGame() {
        return games.stream().max(Comparator.comparing(DiscountGame::getDiscount))
                .orElse(null);
    }

}
