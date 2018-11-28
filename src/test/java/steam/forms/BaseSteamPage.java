package steam.forms;

import framework.BasePage;
import framework.elements.Label;
import org.openqa.selenium.By;

public class BaseSteamPage extends BasePage {
    protected Label lblInstall;
    protected By lblLoc = By.xpath("//a[@class='header_installsteam_btn_content']");

    private final static String RESP_PAGE_IDENT = "responsive_page_content_overlay";

    public BaseSteamPage(String pageIdent) {
        super(pageIdent);
    }

    public void goToInstallPage() throws InterruptedException {
        lblInstall = new Label(lblLoc);
        lblInstall.clickElement();
    }
}
