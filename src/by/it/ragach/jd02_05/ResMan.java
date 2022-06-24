package by.it.ragach.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANSE;

    private Locale locale = new Locale("ru","RU");
    private ResourceBundle resourceBundle;

    ResMan() {
        setLocale(Locale.ENGLISH);
    }
    private static final String baseName = "by.it.ragach.jd02_05.language.text";


    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get (String key){
        return resourceBundle.getString(key);
    }

}
