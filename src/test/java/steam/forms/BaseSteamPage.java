package steam.forms;

import framework.BasePage;
import framework.elements.Label;
import org.openqa.selenium.By;

import java.io.File;

import static framework.BaseTest.conf;

public class BaseSteamPage extends BasePage {
    protected Label lblInstall;
    protected By lblLoc = By.xpath("//a[@class='header_installsteam_btn_content']");

    private final static String RESP_PAGE_IDENT = "responsive_page_content_overlay";

    public BaseSteamPage(String pageIdent) {
        super(pageIdent);
    }

    public void installSteam() throws InterruptedException {
        lblInstall = new Label(lblLoc);
        lblInstall.clickElement();

        String downloadDir = conf.getProperty("downloads.dir.path");
        String downloadExpectedName = conf.getProperty("steam.download.expected-name");
        long pollTime = Long.parseLong(conf.getProperty("downloads.poll-time"));
        Thread.sleep(pollTime); //sleep before download
        File downloaded = new File(downloadDir + downloadExpectedName);
        long prev = 0;
        long next = 0;
        do {
            prev = downloaded.length();
            Thread.sleep(pollTime);
            next = downloaded.length();
        } while (prev != next);
    }
}
