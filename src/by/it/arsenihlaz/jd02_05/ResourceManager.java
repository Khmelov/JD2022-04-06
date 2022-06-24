package by.it.arsenihlaz.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANSE;

    private ResourceBundle resourceBundle;
    private static final String path = "by.it.arsenihlaz.jd02_05.language.file";

    ResourceManager() {
        setLocale(Locale.ENGLISH);
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(path, locale);
    }

    public String getValue(String key){
        return resourceBundle.getString(key);
    }
}
