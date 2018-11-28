package framework;

import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private final static String REGEX="[^(\\d*\\.)?\\d+]";
    private final static String REGEX_BR = "br>((\\d*\\.)?\\d+)<";
    public static final String REGEX_COMMA = ",";
    public static final String REGEX_DOT = ".";
    public static final String REGEX_REMOVE = "";
    public static final String BR_PRICE_REGEX = ".*<br>\\s*(?<price>[^\\s]*).*";

    public static By getLocatorWithPattern(String pattern, String elemIdent) {
        return By.xpath(String.format(pattern, elemIdent));
    }

    public static double parseDoubleNumberFromElementText(BaseElement be) {
        return getaDouble(be.getElementText().replaceAll(REGEX, REGEX_REMOVE));
    }

    public static double parseDoubleNumberFromBrText(BaseElement be) {
        Pattern pricePattern = Pattern.compile(BR_PRICE_REGEX, Pattern.DOTALL);
        System.out.println(be.getElementAttr("innerHTML"));
        Matcher priceMatcher = pricePattern.matcher(be.getElementAttr("innerHTML"));
        priceMatcher.matches();
        String priceContent = priceMatcher.group("price").trim();
        return getaDouble(priceContent);
    }

    private static double getaDouble(String priceContent) {
        System.out.println(priceContent);
        return Double.parseDouble(priceContent.replaceAll(REGEX_COMMA, REGEX_DOT));
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
