package steam.forms;

import framework.Label;
import framework.Span;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DiscountGame {
    private Label game;
    private Span name;
    private Span discountSpan;
    By nameLoc=By.xpath("//div/span[@class='title']");
    By labelLoc=By.xpath("/.");
    By discLoc=By.xpath("//div[contains(@class,'search_discount')]/span");

    public DiscountGame(WebElement el) {
        this.game= new Label(el, labelLoc);
        this.name=new Span(el, nameLoc);
        this.discountSpan=new Span(el, discLoc);
    }
}
