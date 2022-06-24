package by.it.smirnov.jd02_05.service;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    public Locale locale = Locale.getDefault();
    private static final String basename = "by.it.smirnov.jd02_05.language.text";

    ResManager() {
        resourceBundle = ResourceBundle.getBundle(basename, Locale.getDefault());;
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(basename, locale);
        this.locale = locale;
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }

}
