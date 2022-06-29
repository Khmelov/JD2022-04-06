package by.it.selvanovich.jd02_05;

import by.it.selvanovich.jd02_05.constants.Command;
import by.it.selvanovich.jd02_05.constants.Message;
import by.it.selvanovich.jd02_05.constants.User;

import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANSE;
        Locale locale = args.length == 2
                ? new Locale(args[0], args[1])
                : Locale.ENGLISH;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String localeCommand = scanner.nextLine();
            switch (localeCommand) {
                case "ru", "en", "be" -> locale = new Locale(localeCommand);
                default -> {}
            }
            resMan.setLocale(locale);
            long currentTime = System.currentTimeMillis();
            System.out.println(resMan.getFormatedDate(currentTime));
            System.out.println(resMan.get(Message.WELCOME));
            System.out.println(resMan.get(Message.QUESTION));
            System.out.println(resMan.get(User.FIRST_NAME));
            System.out.println(resMan.get(User.LAST_NAME));
            System.out.println(resMan.get(Command.COMMAND));
        }


    }
}
