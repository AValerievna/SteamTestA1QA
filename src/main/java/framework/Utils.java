package framework;

import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private final static String REGEX = "[^(\\d*.)?\\d+]";
    private static final String REGEX_COMMA = ",";
    private static final String REGEX_DOT = "\\.";
    private static final String REGEX_REMOVE = "";
    private static final String BR_PRICE_REGEX = ".*<br>\\s*(?<price>[^\\s]*).*";

    public static By getLocatorWithPattern(String pattern, String elemIdent) {
        return By.xpath(String.format(pattern, elemIdent));
    }

    public static double parseDoubleNumberFromElementText(BaseElement be) {
        return Double.parseDouble(be.getElementText().replaceAll(REGEX_DOT, REGEX_REMOVE).replaceAll(REGEX_COMMA, REGEX_DOT).replaceAll(REGEX, REGEX_REMOVE));
    }

    public static double parseDoubleNumberFromBrText(BaseElement be) {
        Pattern pricePattern = Pattern.compile(BR_PRICE_REGEX, Pattern.DOTALL);
        Matcher priceMatcher = pricePattern.matcher(be.getElementAttr("innerHTML"));
        priceMatcher.matches();
        String priceContent = priceMatcher.group("price").trim();
        return Double.parseDouble((priceContent).replaceAll(REGEX_COMMA, REGEX_DOT));
    }
}
