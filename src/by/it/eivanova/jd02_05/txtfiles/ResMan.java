package by.it.eivanova.jd02_05.txtfiles;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private ResourceBundle resourceBundle;

    ResMan(){
        setLocale(Locale.ENGLISH);
    }
    private static final String baseName = "by.it.eivanova.jd02_05.languages.text";

    public  void setLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }

}
