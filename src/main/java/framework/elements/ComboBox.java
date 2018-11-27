package framework.elements;

import framework.BaseElement;
import framework.BaseElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ComboBox extends BaseElement {
    List<BaseElement> options;
    private By optLoc=By.xpath(".");

    public ComboBox(By locator) {
        super(locator);
    }

    public ComboBox(WebElement el, By locator) {
        super(el, locator);
    }
    public void getOptions(){
        options=new ArrayList<>();
        List<WebElement> tagOptions =new BaseElements(optLoc).getElements();
        for(WebElement el: tagOptions)
            options.add(new Option(el,optLoc));
    }

    public void clickOption(String cnt) {
        this.clickElement();
       /* getOptions();
        for(BaseElement el : options) {
            if(el.getElementText().equals(cnt)) {
                el.clickElement();
            }
        }*/
    }
}
