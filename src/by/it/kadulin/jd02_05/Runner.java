package by.it.kadulin.jd02_05;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        Scanner sc = new Scanner(System.in);
        String localStr = "";
        Locale locale;
        ZonedDateTime zdt;
        DateTimeFormatter dtf;
        while (!localStr.equals("end")) {
             localStr = sc.nextLine();
            switch (localStr) {
                case "ru":
                    locale = new Locale("ru", "RU");
                    resMan.setLocale(locale);
                    printText(resMan);
                    zdt = ZonedDateTime.now();
                    dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm", locale);
                    System.out.println(dtf.format(zdt));

                    break;
                case "en":
                    locale = new Locale("en", "EN");
                    resMan.setLocale(locale);
                    printText(resMan);
                    zdt = ZonedDateTime.now();dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm", locale);
                    System.out.println(dtf.format(zdt));

                    break;
                case "pl":
                    locale = new Locale("pl", "PL");
                    resMan.setLocale(locale);
                    printText(resMan);
                    zdt = ZonedDateTime.now();dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm", locale);
                    System.out.println(dtf.format(zdt));

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
