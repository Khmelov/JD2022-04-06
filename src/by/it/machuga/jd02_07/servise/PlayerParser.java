package by.it.machuga.jd02_07.servise;

import by.it.machuga.jd02_07.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.machuga.jd02_07.interfaces.Constants.*;

public class PlayerParser {

    public Player getPlayer(String line) {
        String name = getValue(line, NAME_PATTERN);
        Integer age = Integer.parseInt(getValue(line, AGE_PATTERN));
        boolean isActive = Boolean.parseBoolean(getValue(line, IS_ACTIVE_PATTERN));
        return new Player(name, age, isActive);
    }

    private String getValue(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        String value = EMPTY_STRING;
        if (matcher.find()) {
            value = matcher.group();
        }
        return value;
    }
}
