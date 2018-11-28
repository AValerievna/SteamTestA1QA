package steam.forms;

import framework.Utils;
import framework.elements.Div;
import framework.elements.Label;
import framework.elements.Span;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DiscountGame {
    private Label game;
    private Span name;
    private Span discountSpan;
    private Div price;
    private By nameLoc = By.xpath(".//div/span[@class='title']");
    private By labelLoc = By.xpath(".//.");
    private By discLoc = By.xpath(".//div[contains(@class,'search_discount')]/span");
    private By priceLoc = By.xpath(".//div//div[contains(@class,'search_price discounted')]");


    Label getGameLabel() {
        return game;
    }

    public double getPriceDouble() {
        return Utils.parseDoubleNumberFromBrText(price);
    }

    public double getDiscDouble() {
        return Utils.parseDoubleNumberFromElementText(discountSpan);
    }

    DiscountGame(WebElement el) {
        this.game= new Label(el, labelLoc);
        this.name=new Span(el, nameLoc);
        this.discountSpan=new Span(el, discLoc);
        this.price= new Div(el,priceLoc);
    }

}
