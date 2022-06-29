package by.it.selvanovich.jd02_05;

import java.text.DateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANSE;

    private ResourceBundle resourceBundle;
    private DateFormat dateFormat;

    ResMan() {
        setLocale(Locale.ENGLISH);
    }

    private static final String baseName = "by.it.selvanovich.jd02_05.language.text";

    public void setLocale(Locale locale) {
        dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

    public String getFormatedDate(long date) {
        return dateFormat.format(date);
    }


}
