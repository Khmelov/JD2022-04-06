package by.it.arsenihlaz.jd02_05;

import by.it.arsenihlaz.jd02_05.constant.Message;
import by.it.arsenihlaz.jd02_05.constant.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResourceManager resourceManager = ResourceManager.INSTANSE;
        Locale locale = args.length == 2
                ? new Locale(args[0], args[1])
                : Locale.ENGLISH;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            if (command.equals("end")) {
                break;
            } else if (command.equals("be")) {
                locale = new Locale("be", "BY");
                System.out.println("усталявана беларуская мова");

            } else if (command.equals("en")) {
                locale = new Locale("en", "EN");
                System.out.println("set to English");

            } else if (command.equals("ru")) {
                locale = new Locale("RU", "RU");
                System.out.println("установлен русский язык");

            } else if (command.equals("print")) {
                printDate(resourceManager, locale);
                printMessage(resourceManager);
            }
        }
    }

    private static void printDate(ResourceManager resourceManager, Locale locale) {
        resourceManager.setLocale(locale);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", locale);
        String date = LocalDate.now().format(formatter);
        String dayOfWeek = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
        System.out.printf("%s %s \n", dayOfWeek, date);
    }

    private static void printMessage(ResourceManager resourceManager) {
        System.out.println(resourceManager.getValue(Message.WELCOME));
        System.out.println(resourceManager.getValue(Message.QUESTION));
        System.out.println(resourceManager.getValue(User.FIRSTNAME));
        System.out.println(resourceManager.getValue(User.LASTNAME));
    }

}
