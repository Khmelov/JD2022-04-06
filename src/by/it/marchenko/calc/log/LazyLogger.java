package by.it.marchenko.calc.log;

import by.it.marchenko.calc.utility.FilePathFounder;
import jdk.javadoc.doclet.Reporter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LazyLogger implements Log {
    private static final String LOGGER_FILE_NAME = "lazyLog.txt";
    private static final String REPORT_FILE_NAME = "report.txt";
    private static final boolean APPEND_MODE = true;
    private static final String DATE_TIME_PATTERN = "yyyy/MM/dd: HH:mm:ss";
    private static final String LOG_MESSAGE_FORMAT = "%-25s %s%n";
    private static final DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    public static final int INDENT_SIZE = 34;
    public static final String SPACE = " ";
    public static final String NEW_LINE = "\n";

    private final String logFile;
    private final String reportFile;

    private LazyLogger() {
        logFile = FilePathFounder.getFilePath(LOGGER_FILE_NAME);
        reportFile = FilePathFounder.getFilePath(REPORT_FILE_NAME);
    }

    private static class NestedLoggerHolder {
        private static final LazyLogger LOGGER = new LazyLogger();
    }

    public static LazyLogger get() {
        return NestedLoggerHolder.LOGGER;
    }

    @Override
    public void error(String errorMessage) {
        logToFile("ERROR:  " + errorMessage);
    }

    @Override
    public void info(String infoMessage) {
        logToFile("INFO:   " + infoMessage);
    }

    @Override
    public void result(String resultMessage) {
        logToFile("RESULT: " + resultMessage);
    }


    private void logToFile(String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(logFile, APPEND_MODE));
             PrintWriter reportWriter = new PrintWriter(new FileWriter(reportFile, APPEND_MODE))) {
            String[] lines = message.split(NEW_LINE);
            StringBuilder formattedMessage = new StringBuilder(lines[0] + NEW_LINE);
            if (lines.length > 1) {
                for (int i = 1; i < lines.length; i++) {
                    formattedMessage
                            .append(SPACE.repeat(INDENT_SIZE))
                            .append(lines[i])
                            .append(NEW_LINE);
                }
            }
            message = formattedMessage.toString();

            printWriter.printf(LOG_MESSAGE_FORMAT,
                    LocalDateTime.now().format(formatDate),
                    message);
            reportWriter.printf(LOG_MESSAGE_FORMAT,
                    LocalDateTime.now().format(formatDate),
                    message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
