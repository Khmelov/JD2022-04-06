package by.it.marchenko.jd_02_06.TaskB;

import by.it.marchenko.jd_02_06.TaskA.Log;
import by.it.marchenko.jd_02_06.TaskA.utility.FilePathFounder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public enum Logger implements Log {
    ENUM_LOGGER;
    private static final String LOGGER_FILE_NAME = "log.txt";
    private static final boolean APPEND_MODE = true;
    private static final String DATE_TIME_PATTERN = "yyyy/MM/dd: HH:mm:ss";
    private static final String LOG_MESSAGE_FORMAT = "%-25s %s%n";
    private static final DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    private final String logFile;

    Logger() {
        logFile = FilePathFounder.getFilePath(LOGGER_FILE_NAME);
    }

    public static Logger get() {
        return ENUM_LOGGER;
    }

    @Override
    public void error(String errorMessage) {
        logToFile("ERROR: " + errorMessage);
    }

    @Override
    public void info(String infoMessage) {
        logToFile("INFO:  " + infoMessage);
    }

    private void logToFile(String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(logFile, APPEND_MODE))) {
            printWriter.printf(LOG_MESSAGE_FORMAT,
                    LocalDateTime.now().format(formatDate),
                    message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
