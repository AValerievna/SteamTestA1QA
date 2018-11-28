package steam.forms;

import framework.BaseElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpecialsPage extends BaseSteamPage {
    List<DiscountGame> games = new ArrayList<>();
    DiscountGame neededGame;
    By discGameLocator = By.xpath("//div[contains(@class,'search_discount')]/span/ancestor::a[contains(@class, 'search_result_row')]");
    //div[contains(@class,'search_discount')]/span/ancestor::a[contains(@class, 'search_result_row')]
    private final static String RESP_PAGE_IDENT = "responsive_page_content_overlay";


    public SpecialsPage() {
        super(RESP_PAGE_IDENT);
    }

    public void getDiscountGames() {
        List<WebElement> webElems =new BaseElements(discGameLocator).getElements();
        for(WebElement elem : webElems) {
            games.add(new DiscountGame(elem));
        }
    }

    public void getLargestDiscountGame() {
        getDiscountGames();
        neededGame= getGame();
    }

    public void goToNeededGame() {
        neededGame.getGameLabel().clickElement();
    }

    public DiscountGame getNeededGame() {
        return neededGame;
    }

    DiscountGame getGame() {
        return games.stream().max(Comparator.comparing(DiscountGame::getDiscDouble))
                .orElse(null);
    }
}
