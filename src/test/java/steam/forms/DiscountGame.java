package steam.forms;

import framework.elements.Div;
import framework.elements.Label;
import framework.elements.Span;
import framework.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DiscountGame {
    private Label game;
    private Span name;
    private Span discountSpan;
    private Div price;
    By nameLoc=By.xpath(".//div/span[@class='title']");
    By labelLoc=By.xpath(".//.");
    By discLoc=By.xpath(".//div[contains(@class,'search_discount')]/span");
    By priceLoc = By.xpath(".//div//div[contains(@class,'search_price')]");

    public Label getGameLabel() {
        return game;
    }

/*    public Span getDiscountSpan() {
        return discountSpan;
    }*/
    public Div getPrice() {
        return price;
    }

    public int getDiscount() {
        return Utils.parseIntegerNumberFromElementText(discountSpan);
    }

    public DiscountGame(WebElement el) {
        this.game= new Label(el, labelLoc);
        this.name=new Span(el, nameLoc);
        this.discountSpan=new Span(el, discLoc);
        this.price= new Div(el,priceLoc);
    }

}
