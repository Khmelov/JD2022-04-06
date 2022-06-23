package by.it.smirnov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private static final String basename = "by.it.smirnov.jd02_05.language.text";

    ResManager() {
        setLocale(Locale.ENGLISH);
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(basename, locale);
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }

}
