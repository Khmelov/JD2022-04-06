package by.it.arsenihlaz.calculator;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANSE;

    private ResourceBundle resourceBundle;
    private static final String path = "by.it.arsenihlaz.calculator.language.exception";

    ResourceManager() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(path, locale);
    }

    public String getValue(String key){
        return resourceBundle.getString(key);
    }
}
