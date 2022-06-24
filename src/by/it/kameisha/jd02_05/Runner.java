package by.it.kameisha.jd02_05;


import by.it.kameisha.jd02_05.constants.Message;
import by.it.kameisha.jd02_05.constants.User;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANSE;
        Locale locale = args.length == 2 ? new Locale(args[0], args[1]) : new Locale("");
        resMan.setLocale(locale);
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.FIRSTNAME));
        System.out.println(resMan.get(User.LASTNAME));
    }
}