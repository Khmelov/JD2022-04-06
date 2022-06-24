package by.it.annazhegulovich.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANSE;
        Locale locale = args.length == 2 ? new Locale(args[0], args[1]) : Locale.ENGLISH;
        resMan.setLocale(locale);
        System.out.println(resMan.get(massage.WELCOME));
        System.out.println(resMan.get(massage.QUESTION1));
        System.out.println(resMan.get(massage.QUESTION2));
        System.out.println(resMan.get(answer.QUESTION1));
        System.out.println(resMan.get(answer.QUESTION2));
    }
}
