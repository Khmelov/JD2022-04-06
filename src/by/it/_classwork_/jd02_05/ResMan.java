package by.it._classwork_.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANSE;
    
    private ResourceBundle resourceBundle;
    
    ResMan() {
        setLocale(Locale.ENGLISH);
    }

    private static final String baseName = "by.it._classwork_.jd02_05.language.text";

    public void setLocale(Locale locale) {
        resourceBundle=ResourceBundle.getBundle(baseName, locale);
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }


}
