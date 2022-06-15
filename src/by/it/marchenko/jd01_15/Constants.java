package by.it.marchenko.jd01_15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Constants {
    public static final String CHANGE_DIRECTORY_COMMAND = "cd";
    public static final String SHOW_DIRECTORY_COMMAND = "dir";
    public static final String EXIT_APP_COMMAND = "end";

    public static final Set<String> COMMANDS = new HashSet<>(Arrays.asList(
            CHANGE_DIRECTORY_COMMAND, SHOW_DIRECTORY_COMMAND, EXIT_APP_COMMAND));

    public static final String SPACE_PATTERN = "[\\.\s]+";
    // cd.. cd. cd q
    public static final String EMPTY_STRING = "";

    public static final String COMMAND_NOT_FOUND_MESSAGE = "Command not found";
    public static final String GREETING_MESSAGE = "Application start. Available command: DIR, CD <>, END";
    public static final String FAREWELL_MESSAGE = "Application finish";

    public static final String INCORRECT_FILE_PATH_MESSAGE = "The system cannot find the path specified.";
    public static final String SPECIFY_PATH_MESSAGE = "It is need to specify path for directory changing";
    public static final String INVALID_DIRECTORY_NAME_MESSAGE = "The directory name is invalid.";


    public static final String INPUT_ERROR_EXCEPTION = "Input error";
}
