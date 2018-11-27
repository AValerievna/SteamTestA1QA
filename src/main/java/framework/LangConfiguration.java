package framework;

import java.util.Locale;
import java.util.ResourceBundle;

public class LangConfiguration {
    public LangConfiguration() {
        ResourceBundle english = ResourceBundle.getBundle("localization", Locale.ENGLISH);
        ResourceBundle russian = ResourceBundle.getBundle("localization", Locale.forLanguageTag("ru"));
    }

    public String getProperty(String propName, Locale locale) {
        return  ResourceBundle.getBundle("localization", locale).getString(propName);
    }
}
