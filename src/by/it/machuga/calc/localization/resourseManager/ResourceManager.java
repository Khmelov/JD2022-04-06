package by.it.machuga.calc.localization.resourseManager;

import by.it.machuga.calc.constans.ConstantStorage;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private Locale locale = Locale.ENGLISH;
    private ResourceBundle resourceBundle;
    private static final String baseName = ConstantStorage.PATH;

    ResourceManager() {
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
