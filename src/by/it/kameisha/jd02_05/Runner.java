package by.it.kameisha.jd02_05;


import by.it.kameisha.jd02_05.constants.Message;
import by.it.kameisha.jd02_05.constants.User;

import java.text.DateFormat;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        Locale locale = args.length == 2 ? new Locale(args[0], args[1]) : new Locale("");
        startWithLocaleConfig(resMan, locale);
        Scanner scanner = new Scanner(System.in);
        List<String> locales= new ArrayList<>(Arrays.asList("ru","en","be"));
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("end")){
                break;
            }else if(locales.contains(input)){
                locale = new Locale(input.trim());
                startWithLocaleConfig(resMan,locale);
            }
        }
    }

    private static void startWithLocaleConfig(ResMan resMan, Locale locale) {
        resMan.setLocale(locale);
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println(dateInstance.format(new Date()));
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.FIRSTNAME));
        System.out.println(resMan.get(User.LASTNAME));
    }
}