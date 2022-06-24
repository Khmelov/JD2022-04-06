package by.it.kameisha.jd02_05;

import by.it.kameisha.jd02_05.constants.Message;
import by.it.kameisha.jd02_05.constants.User;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private static final String baseName = "by.it.kameisha.jd02_05.language.text";
    private ResourceBundle resourceBundle;

    ResMan() {
        setLocale(new Locale(""));
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
    public void startWithLocaleConfig(Locale locale) {
        setLocale(locale);
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println(dateInstance.format(new Date()));
        System.out.println(get(Message.WELCOME));
        System.out.println(get(Message.QUESTION));
        System.out.println(get(User.FIRSTNAME));
        System.out.println(get(User.LASTNAME));
    }
}
