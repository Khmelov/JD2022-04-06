package by.it.kadulin.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        Locale locale = args.length == 2 ? new Locale(args[0], args[1]) : Locale.ENGLISH;
        resMan.setLocale(locale);
        System.out.println(resMan.get(Message.welcome));
        System.out.println(resMan.get(Message.question));
        System.out.println(resMan.get(User.firstName));
        System.out.println(resMan.get(User.lastName));
    }
}
