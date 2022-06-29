package by.it.machuga.jd02_05;

import by.it.machuga.jd02_05.constants.Constants;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private Locale locale = Locale.ENGLISH;
    private ResourceBundle resourceBundle;

    ResourceManager() {
        setLocale(locale);
    }

    private static final String baseName = Constants.PATH;

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
