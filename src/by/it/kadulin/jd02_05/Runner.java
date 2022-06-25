package by.it.kadulin.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        Scanner sc = new Scanner(System.in);
        String localeStr = "";
        while (!localeStr.equals("end")) {
             localeStr = sc.nextLine();
            switch (localeStr) {
                case "ru": resMan.setLocale(new Locale("ru", "RU"));
                    printText(resMan);
                    break;
                case "en": resMan.setLocale(new Locale("en", "EN"));
                    printText(resMan);
                    break;
                case "pl": resMan.setLocale(new Locale("pl", "PL"));
                    printText(resMan);
                    break;
            }
        }
//        Locale locale = args.length == 2 ? new Locale(args[0], args[1]) : Locale.ENGLISH;
//        resMan.setLocale(locale);

    }

    private static void printText(ResMan resMan) {
        System.out.println(resMan.get(Message.welcome));
        System.out.println(resMan.get(Message.question));
        System.out.println(resMan.get(User.firstName));
        System.out.println(resMan.get(User.lastName));
    }
}
