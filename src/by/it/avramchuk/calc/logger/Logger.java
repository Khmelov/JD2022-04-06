package by.it.avramchuk.calc.logger;

import by.it.avramchuk.calc.constants.Patterns;
import by.it.avramchuk.calc.interfaces.Log;
import by.it.avramchuk.calc.util.DateFormatter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Logger implements Log {


    private Logger() {
    }

    private static class InstanceLogger {

        static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return InstanceLogger.INSTANCE;
    }


    @Override
    public String logError(String message) {
        String newMessage = DateFormatter.getDateTime() + "Error: " + message;
        writeTo(Patterns.LOG_PATH, newMessage);
        writeTo(Patterns.REPORT_PATH, DateFormatter.getTime() + ">" + message);
        return message;
    }

    @Override
    public String logInfo(String message) {
        String newMessage = DateFormatter.getDateTime() + "Info: " + message;
        writeTo(Patterns.LOG_PATH, newMessage);
        writeTo(Patterns.REPORT_PATH, DateFormatter.getTime() + ">" + message);
        return message;
    }

    public void logDate() {
        writeFirst(Patterns.REPORT_PATH, DateFormatter.getDateTime());
    }

    public void writeTo(String path, String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFirst(String path, String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            writer.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
