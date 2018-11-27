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
    By nameLoc=By.xpath(".//div/span[@class='title']");
    By labelLoc=By.xpath(".//.");
    By discLoc=By.xpath(".//div[contains(@class,'search_discount')]/span");
    By priceLoc = By.xpath(".//div//div[contains(@class,'search_price discounted')]");

    private double discDouble;
    private double priceDouble;

    public double getDiscDouble() {
        return discDouble;
    }

    public double getPriceDouble() {
        return priceDouble;
    }


    public Label getGameLabel() {
        return game;
    }

    public void setPrice() {
        priceDouble = Utils.parseDoubleNumberFromElementText(price);
    }

    public void setDiscount() {
        discDouble = Utils.parseDoubleNumberFromElementText(discountSpan);
    }

    public DiscountGame(WebElement el) {
        this.game= new Label(el, labelLoc);
        this.name=new Span(el, nameLoc);
        this.discountSpan=new Span(el, discLoc);
        this.price= new Div(el,priceLoc);
    }

}
