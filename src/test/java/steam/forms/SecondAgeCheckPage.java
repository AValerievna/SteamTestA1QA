package steam.forms;

import framework.BasePage;
import framework.elements.Label;
import org.openqa.selenium.By;

public class SecondAgeCheckPage extends BasePage {

    private Label lblSubmit;
    private final static String respPageIdent="responsive_page_content_overlay";
    public SecondAgeCheckPage() {
        super(respPageIdent);
    }
    private By submLoc = By.xpath("//div[@class='agegate_text_container btns']//span[contains(text(),'Открыть страницу')]");

    public void submitAge() {
        lblSubmit = new Label(submLoc);
        lblSubmit.clickElement();
    }

}