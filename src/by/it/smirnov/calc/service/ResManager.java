package by.it.smirnov.calc.service;

import java.util.Locale;
import java.util.ResourceBundle;

import static by.it.smirnov.calc.constants.Wordings.CHANGE_LOCAL;
import static java.lang.System.out;

public enum ResManager {
    INSTANCE;
    public ResourceBundle resourceBundle;
    private static final String basename = "by.it.smirnov.calc.language.text";

    ResManager() {
        resourceBundle = ResourceBundle.getBundle(basename, Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(basename, locale);
        out.println(getString((CHANGE_LOCAL)));
    }

    public String getString(String key){
        return resourceBundle.getString(key);
    }

}
