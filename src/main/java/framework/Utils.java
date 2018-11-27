package framework;

import org.openqa.selenium.By;

public class Utils {

    private final static String REGEX="[^(\\d*\\.)?\\d+]";
    public static By getLocatorWithPattern(String pattern, String elemIdent) {
        return By.xpath(String.format(pattern, elemIdent));
    }

    public static double parseDoubleNumberFromElementText(BaseElement be) {
        System.out.println((be.getElementText()));
        System.out.println((be.getElementText().replaceAll(",",".")));
        System.out.println((be.getElementText().replaceAll(",",".").replaceAll(REGEX,"")));
        
        return Double.parseDouble(be.getElementText().replaceAll(",",".").replaceAll(REGEX,""));
    }


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
