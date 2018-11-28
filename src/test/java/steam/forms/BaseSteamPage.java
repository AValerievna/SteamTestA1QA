package steam.forms;

import framework.BasePage;
import framework.elements.Label;
import org.openqa.selenium.By;

public class BaseSteamPage extends BasePage {
    private static final String EN = "en";
    private Label lblInstall;
    private By lblLoc = By.xpath("//a[@class='header_installsteam_btn_content']");
    private By langChooseLoc = By.xpath("//span[@id='language_pulldown']");
    private Label lblChooseLang;
    private Label lblLang;
    SteamMenu stMenu = new SteamMenu();
    private By lang = By.xpath("//a[contains(text(),'English')]");

    BaseSteamPage(String pageIdent) {
        super(pageIdent);
    }

    public void goToInstallPage() throws InterruptedException {
        lblInstall = new Label(lblLoc);
        lblInstall.clickElement();
    }

    public void isEngLanguage(String prop) {
        if (prop.equals(EN)) {
            lblChooseLang = new Label(langChooseLoc);
            lblChooseLang.clickElement();

            lblLang = new Label(lang);
            lblLang.clickElement();
        }
    }

}
