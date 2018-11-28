package steam.forms;

import framework.elements.Label;
import org.openqa.selenium.By;

import java.io.File;

import static framework.BaseTest.conf;

public class InstallPage extends BaseSteamPage {

    private Label lblInst;
    private final static String RESP_PAGE_IDENT = "responsive_page_content_overlay";
    private By lblInstLoc = By.xpath("//div[@id='about_greeting_ctn']//a[@id='about_install_steam_link']");

    public InstallPage() {
        super(RESP_PAGE_IDENT);
    }

    public void installSteam() throws InterruptedException {
        lblInst = new Label(lblInstLoc);
        lblInst.clickElement();

        String downloadDir = conf.getProperty("downloads.dir.path");
        String downloadExpectedName = conf.getProperty("steam.download.expected-name");
        long pollTime = Long.parseLong(conf.getProperty("downloads.poll-time"));
        Thread.sleep(pollTime); //sleep before download
        File downloaded = new File(downloadDir + downloadExpectedName);
        long startTime = System.currentTimeMillis();
        long prev;
        long next;
        long maxWait = conf.getIntProperty("max-download-wait-ms");
        do {
            prev = downloaded.length();
            Thread.sleep(pollTime);
            next = downloaded.length();
            System.out.printf("%d %d\n", prev, next);
        } while (((prev != next) || prev <= 0) && (System.currentTimeMillis() - startTime) < maxWait);
    }
}

