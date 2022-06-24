package by.it.annazhegulovich.jd02_05_b;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANSE;

    private ResourceBundle resourceBundle;

    ResMan(){
        setLocale(Locale.ENGLISH);
    }

    public static final String baseName = "by.it.annazhegulovich.jd02_05.propertyFiles.text";


    public void setLocale (Locale locale){
       resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get (String key){
        return resourceBundle.getString(key);
    }


}
