package by.it.machuga.jd02_05;

import by.it.machuga.jd02_05.constants.Constants;
import by.it.machuga.jd02_05.constants.Message;
import by.it.machuga.jd02_05.constants.User;

import java.util.Locale;

public class Runner {

    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;

        Locale locale = args.length == Constants.INT_TWO ?
                new Locale(args[Constants.INT_ZERO], args[Constants.INT_ONE]) :
                Locale.ENGLISH;

        resMan.setLocale(locale);
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.MY_NAME_IS));
        System.out.println(resMan.get(User.FIRST_NAME));
        System.out.println(resMan.get(User.LAST_NAME));
    }
}
