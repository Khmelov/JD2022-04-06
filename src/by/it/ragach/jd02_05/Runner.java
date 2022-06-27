package by.it.ragach.jd02_05;

import by.it.ragach.jd02_05.constants.Message;
import by.it.ragach.jd02_05.constants.User;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANSE;

        Locale locale = args.length == 2
                ? new Locale(args[0], args[1])
                : Locale.ENGLISH;

        resMan.setLocale(locale);

        System.out.println(resMan.get(Message.START));
        Scanner scanner = new Scanner(System.in);
        String inPut = scanner.nextLine();
        locale = new Locale(inPut);
        resMan.setLocale(locale);

        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.FIRST_NAME));
        System.out.println(resMan.get(User.LAST_NAME));

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd MMMM yyyy", locale);
        String time = dateTimeFormatter.format(zonedDateTime);
        System.out.println(time);


    }
}
