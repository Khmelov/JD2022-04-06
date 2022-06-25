package by.it.kudelko.jd02_05;

import by.it.kudelko.jd02_05.constants.Message;
import by.it.kudelko.jd02_05.constants.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANSE;
        Locale locale = args.length == 2
                ? new Locale(args[0], args[1])
                : Locale.ENGLISH;

        Scanner sc = new Scanner(System.in);
        label:
        while (sc.hasNext()) {
            String field = sc.nextLine();
            switch (field) {
                case "stop":
                    break label;
                case "be":
                    locale = new Locale("be", "BY");
                    System.out.println("Мова зменена на беларускую");
                    break;
                case "en":
                    locale = new Locale("en", "EN");
                    System.out.println("Set English");
                    break;
                case "ru":
                    locale = new Locale("ru", "RU");
                    System.out.println("Язык изменен на русский");
                    break;
                case "Hello":
                    printCurrentDate(resMan, locale);
                    printCurrentMessage(resMan);
                    break;
            }
        }
    }

    private static void printCurrentDate(ResMan resMan, Locale locale) {
        resMan.setLocale(locale);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMM.yyyy", locale);
        String date = LocalDate.now().format(formatter);
        String day = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
        System.out.printf("%s %s \n", day, date);
    }

    private static void printCurrentMessage(ResMan resMan) {
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.FIRST_NAME));
        System.out.println(resMan.get(User.LAST_NAME));
    }
}
