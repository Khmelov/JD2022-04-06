package by.it.smirnov.jd02_05;

import java.util.Locale;
import java.util.Scanner;

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
        String command = "";
        Scanner scanner = new Scanner(System.in);
        while (!command.equals(END)) {
            out.println(resManager.get(WELCOME));
            out.println(resManager.get(QUESTION));
            out.println(resManager.get(FIRST_NAME));
            out.println(resManager.get(LAST_NAME));
            out.println(resManager.get(COMMAND));
            command = scanner.nextLine();
            switch (command) {
                case (FR) -> resManager.setLocale(Locale.CANADA_FRENCH);
                case (JP) -> resManager.setLocale(Locale.JAPAN);
                case (RU) -> resManager.setLocale(new Locale("ru", "RU"));
                case (BE) -> resManager.setLocale(new Locale("be", "BY"));
                default -> resManager.setLocale(Locale.ENGLISH);
            }
        }
    }
}
