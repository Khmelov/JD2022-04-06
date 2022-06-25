package by.it.marchenko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {

    INSTANCE;
    private final String resourceName = "by.it.marchenko.jd02_05.language.sentences";
    private ResourceBundle resourceBundle;

    ResourceManager() {
        this.resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }

    public void changeResource(Locale locale) {
        this.resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }
}
