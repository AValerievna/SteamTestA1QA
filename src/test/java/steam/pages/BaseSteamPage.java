package steam.pages;

import org.openqa.selenium.By;

import java.lang.invoke.LambdaConversionException;
import java.util.Locale;

import static framework.BaseTest.conf;

public class BaseSteamPage {
    public void setLanguage() {
        Label menu = Label(By.xpath(String.format(Locale.ENGLISH)))
    }
}
