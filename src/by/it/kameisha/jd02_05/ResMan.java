package by.it.kameisha.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private static final String baseName = "by.it.kameisha.jd02_05.language.text";
    private ResourceBundle resourceBundle;

    ResMan() {
        setLocale(new Locale(""));
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}