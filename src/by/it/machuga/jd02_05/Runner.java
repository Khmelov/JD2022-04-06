package by.it.machuga.jd02_05;

import by.it.machuga.jd02_05.constants.Constants;
import by.it.machuga.jd02_05.constants.Date;
import by.it.machuga.jd02_05.constants.Message;
import by.it.machuga.jd02_05.constants.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Locale locale = getLocale();
        ResourceManager resourceManager = getResourceManager(locale);
        communicate(locale, resourceManager);
    }

    private static Locale getLocale() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.SELECT_LANGUAGE_MSG);
        String language = scanner.next().toLowerCase();
        Locale locale;
        switch (language) {
            case Constants.RU_LANGUAGE -> locale = new Locale(Constants.RU_LANGUAGE, Constants.RU_COUNTRY);
            case Constants.BE_LANGUAGE -> locale = new Locale(Constants.BE_LANGUAGE, Constants.BY_COUNTRY);
            default -> locale = new Locale(Constants.EN_LANGUAGE, Constants.US_COUNTRY);
        }
        return locale;
    }

    private static ResourceManager getResourceManager(Locale locale) {
        ResourceManager resourceManager = ResourceManager.INSTANCE;
        resourceManager.setLocale(locale);
        return resourceManager;
    }

    private static void communicate(Locale locale, ResourceManager resourceManager) {
        System.out.println(resourceManager.get(Message.WELCOME));
        System.out.println(resourceManager.get(Message.MY_NAME_IS));
        System.out.println(resourceManager.get(User.FIRST_NAME));
        System.out.println(resourceManager.get(User.LAST_NAME));
        System.out.println(resourceManager.get(Message.TODAY) + " " +
                new SimpleDateFormat(resourceManager.get(Date.FORMAT), locale).format(Calendar.getInstance().getTime()));
    }
}
