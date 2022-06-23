package by.it.smirnov.jd02_05;

import java.util.Locale;

import static by.it.smirnov.jd02_05.Constants.*;
import static java.lang.System.out;

public class Runner {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ResManager resManager = ResManager.INSTANCE;
        if (args.length == 2) {
            resManager.setLocale(new Locale(args[0], args[1]));
        } else {
            resManager.setLocale(Locale.ENGLISH);
        }
        out.println(resManager.get(WELCOME));
        out.println(resManager.get(QUESTION));
        out.println(resManager.get(FIRST_NAME));
        out.println(resManager.get(LAST_NAME));

    }
}
