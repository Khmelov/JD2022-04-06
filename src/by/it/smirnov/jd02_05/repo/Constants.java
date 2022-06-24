package by.it.smirnov.jd02_05.repo;

import java.util.Locale;

public interface Constants {
    String WELCOME = "message.welcome";
    String QUESTION = "message.question";
    String FIRST_NAME = "user.firstname";
    String LAST_NAME = "user.lastname";
    String DATE = "message.date";
    String COMMAND = "command.chooselang";
    String END = "end";
    String EN = "en";
    String FR = "fr";
    String JP = "jp";
    String RU = "ru";
    String BE = "be";
    Locale JAPANESE = new Locale("jp", "JP");
    Locale RUSSIA = new Locale("ru", "RU");
    Locale BELARUS = new Locale("be", "BY");
    String DATE_PATTERN = "EEEE, dd MMMM yyyy, HH:mm:ss";
}
