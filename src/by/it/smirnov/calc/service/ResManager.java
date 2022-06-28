package by.it.smirnov.calc.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import static by.it.smirnov.calc.constants.Patterns.DATE_PATTERN;
import static by.it.smirnov.calc.constants.Patterns.TIME_PATTERN;
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
        Printer printer = new Printer(out);
        resourceBundle = ResourceBundle.getBundle(basename, locale);
        printer.println(getString((CHANGE_LOCAL)));
    }

    public String getString(String key){
        return resourceBundle.getString(key);
    }

    public static String getDate() {
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN, Locale.getDefault());
        return now.format(formatter);
    }

    public static String getTime() {
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_PATTERN, Locale.getDefault());
        return now.format(formatter);
    }

}
