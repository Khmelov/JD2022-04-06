package by.it.marchenko.jd02_05;

import by.it.marchenko.jd02_05.util.Converter;

import java.util.Locale;

public class TaskA implements Message {

    public static final String MESSAGE_FORMAT = "%s %s %s %s.%n";

    public static void main(String[] args) {
        Converter.createResourceFromText();

        Locale locale = args.length < 2 ?
                Locale.ENGLISH :
                new Locale(args[0], args[1]);

        ResourceManager resourceManager = ResourceManager.INSTANCE;
        resourceManager.changeResource(locale);

        System.out.printf(MESSAGE_FORMAT,
                resourceManager.getString(GREETING),
                resourceManager.getString(PERSON),
                resourceManager.getString(FIRSTNAME),
                resourceManager.getString(LASTNAME)
        );
    }
}
