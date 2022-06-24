package by.it.smirnov.jd02_05;

import by.it.smirnov.jd02_05.service.ResManager;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import static by.it.smirnov.jd02_05.repo.Constants.*;
import static by.it.smirnov.jd02_05.service.ResManager.INSTANCE;
import static java.lang.System.out;

public class Runner {

    private static String command = "";
    private static final ResManager resManager = INSTANCE;

    public static void main(String[] args) {
        if (args.length == 2) {
            resManager.setLocale(new Locale(args[0], args[1]));
        }
        while (!command.equals(END)) {
            printMessages();
            printDate();
            out.println(resManager.get(COMMAND));
            changeLocale();
        }
    }

    private static void changeLocale() {
        Scanner scanner = new Scanner(System.in);
        command = scanner.nextLine();
        switch (command) {
            case (FR) -> Runner.resManager.setLocale(Locale.CANADA_FRENCH);
            case (JP) -> Runner.resManager.setLocale(JAPANESE);
            case (RU) -> Runner.resManager.setLocale(RUSSIA);
            case (BE) -> Runner.resManager.setLocale(BELARUS);
            default -> Runner.resManager.setLocale(Locale.ENGLISH);
        }
    }

    private static void printDate() {
        ZonedDateTime now = ZonedDateTime.now();
        Locale dateLocale = generateDateLoc();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN, dateLocale);
        out.printf(resManager.get(DATE), now.format(formatter));
    }

    private static Locale generateDateLoc() {
        if (resManager.locale.equals(JAPANESE)) {
            return Locale.JAPAN;
        } else {
            return resManager.locale;
        }
    }

    private static void printMessages() {
        out.println(resManager.get(WELCOME));
        out.println(resManager.get(QUESTION));
        out.println(resManager.get(FIRST_NAME));
        out.println(resManager.get(LAST_NAME));
    }
}
