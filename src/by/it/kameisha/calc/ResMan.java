package by.it.kameisha.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private static final String baseName = "by.it.kameisha.calc.language.text";
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
