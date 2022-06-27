package by.it.kameisha.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum Logger {
    INSTANCE;
    public static final String LOG_TXT = "log.txt";

    public void log(String message) {
        String path = Util.getPath(Logger.class, LOG_TXT);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))) {
            printWriter.println(message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
