package framework;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LangConfiguration {
    private ResourceBundle bnd;
    private Locale loc;

    LangConfiguration(String locTag) throws IOException {
        loc = Locale.forLanguageTag(locTag);
        bnd = ResourceBundle.getBundle("localization", loc);
    }

    public String getLangProperty(String propName) {
        return ResourceBundle.getBundle("localization", loc).getString(propName);
    }
}
