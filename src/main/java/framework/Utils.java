package framework;

import org.openqa.selenium.By;

public class Utils {

    public static By getLocatorWithPattern(String pattern, String elemIdent) {
        return By.xpath(String.format(pattern, elemIdent));
    }


    //DOWNLOADING
    //FIREFOX CONFIG
    /*FirefoxOptions opts = new FirefoxOptions();
opts.addPreference("browser.download.folderList", 2);
opts.addPreference("browser.download.manager.showWhenStarting", false);
opts.addPreference("browser.download.dir", downloadDir);
opts.addPreference("browser.helperApps.neverAsk.saveToDisk", firefoxNeverAskTypes);
    browser = new FirefoxDriver(opts);*/

    //CHROME CONFIG
    /*ChromeOptions chromeOpts = new ChromeOptions();
    Map<String, Object> chromePrefs = new HashMap<>();
chromePrefs.put("download.default_directory", downloadDir);
chromePrefs.put("download.prompt_for_download", false);
chromePrefs.put("download.directory_upgrade", true);
chromePrefs.put("safebrowsing.enabled", true);
chromeOpts.setExperimentalOption(  "prefs", chromePrefs);
*/
//WAIT FOR LOAD AFTER BUTTON CLICK
/*String downloadDir = conf.getProperty("downloads.dir.path");
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
    } while (prev != next);*/
}
