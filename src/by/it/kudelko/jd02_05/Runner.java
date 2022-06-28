package by.it.kudelko.jd02_05;

import by.it.kudelko.jd02_05.constants.Message;
import by.it.kudelko.jd02_05.constants.User;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANSE;
            Locale locale = args.length==2
                    ? new Locale(args[0], args[1])
                    : Locale.ENGLISH;
        resMan.setLocale(locale);
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.FIRST_NAME));
        System.out.println(resMan.get(User.LAST_NAME));
    }
}
