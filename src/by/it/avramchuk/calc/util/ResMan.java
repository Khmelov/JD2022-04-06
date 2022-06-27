package by.it.avramchuk.calc.util;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private ResourceBundle resourceBundle;

    ResMan(){
        setLocale(Locale.getDefault());
    }
    private static final String baseName = "by.it.avramchuk.calc.languages.text";

    public  void setLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }

}
