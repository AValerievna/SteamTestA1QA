package steam.forms;

import framework.BaseElements;
import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import steam.utils.SteamUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpecialsPage extends BasePage {
    List<DiscountGame> games = new ArrayList<>();
    DiscountGame neededGame;
    By discGameLocator = By.xpath("//a[contains(@class, 'search_result_row')]");
    //div[contains(@class,'search_discount')]/span/ancestor::a[contains(@class, 'search_result_row')]
    private final static String respPageIdent="responsive_page_content_overlay";
    private final static String firstPageIdent = "//select";
    private final static String secondPageIdent = "//div[@class='agegate_text_container btns']//span[contains(text(),'Открыть страницу')]";


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
        return games.stream().max(Comparator.comparing(DiscountGame::getDiscDouble))
                .orElse(null);
    }

    public void agePageExistance() {
        if (this.isPageOpened(firstPageIdent)) {
            SteamUtils.doFirstAgePageCheck();
            return;
        }
        if (this.isPageOpened(secondPageIdent)) {
            SteamUtils.doSecondAgePageCheck();
        }
    }
}
