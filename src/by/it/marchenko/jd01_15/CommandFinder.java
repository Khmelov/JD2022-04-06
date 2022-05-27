package by.it.marchenko.jd01_15;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Objects;

import static by.it.marchenko.jd01_15.Constants.*;

public class CommandFinder {
    private static final boolean SEARCH_TO_SPACE = true;
    private static final boolean SEARCH_TO_END = false;
    private static final String EMPTY_PREFIX = "";
    private static String prefix;

    public LinkedList<String> findCommand(String line) {
        LinkedList<String> commandList = new LinkedList<>();
        try (StringReader in = new StringReader(line.trim())) {
            String firstWord = parseReader(in, SEARCH_TO_SPACE, EMPTY_PREFIX);
            String command = searchedCommand(firstWord);
            commandList.addFirst(command);
            String argument = parseReader(in, SEARCH_TO_END, prefix);
            argument = argument.trim();
            commandList.addLast(argument);
            return commandList;
        } catch (IOException e) {
            throw new RuntimeException(INPUT_ERROR_EXCEPTION, e);
        }

    }

    private String parseReader(StringReader in, boolean toSpace, String prefix) throws IOException {
        if (Objects.isNull(prefix)) {
            return EMPTY_STRING;
        }
        StringBuilder builder = new StringBuilder(prefix);
        while (true) {
            int readCode = in.read();
            if (readCode < 0) {
                break;
            }
            Character symbol = (char) readCode;
            builder.append(symbol);
            if (toSpace) {
                String symbolString = symbol.toString();
                if (symbolString.matches(SPACE_PATTERN)) {
                    CommandFinder.prefix = symbolString;
                    builder.deleteCharAt(builder.length() - 1);
                    break;
                }
            }
        }
        return builder.toString();
    }

    private String searchedCommand(String firstWord) {
        String foundedCommand = COMMAND_NOT_FOUND_MESSAGE;
        if (COMMANDS.contains(firstWord)) {
            foundedCommand = firstWord;
        }
        return foundedCommand;
    }
}
