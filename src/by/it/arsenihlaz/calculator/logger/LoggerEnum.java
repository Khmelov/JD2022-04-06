package by.it.arsenihlaz.calculator.logger;

import by.it.arsenihlaz.jd01_14.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum LoggerEnum implements Log {
    INSTANCE;

    public LoggerEnum getValue() {
        return INSTANCE;
    }

    @Override
    public void error(String messageError) {
        logToFile("ERROR: " + messageError);
    }

    @Override
    public void info(String messageInfo) {
        logToFile("INFO:  " + messageInfo);
    }

    private void logToFile(String message) {
        String path = Util.getPath(LoggerEnum.class, "log.txt");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM.yyyy");
            String date = LocalDate.now().format(formatter);
            printWriter.printf("%s: %s \n", date, message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
