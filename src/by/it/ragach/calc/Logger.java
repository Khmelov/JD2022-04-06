package by.it.ragach.calc;

import by.it.ragach.calc.constants.Patterns;

import java.io.*;
import java.text.DateFormat;

public class Logger implements Log{

    private Logger(){

    }

    private static class InstanceLogger{
        static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance(){
        return InstanceLogger.INSTANCE;
    }

    @Override
    public String logError(String message) {
        String newMessage = DateFormatter.getDateTime() + "Error: " + message;
        writeTo(Patterns.LOG_PATH,newMessage);
        writeTo(Patterns.REPORT_PATH,DateFormatter.getTime()+message);
        return message;

    }

    public void writeTo(String path, String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))){

            writer.println(message);

            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String logInfo(String message) {
        String newMessage = DateFormatter.getDateTime() + "Info: " + message;
        writeTo(Patterns.LOG_PATH,newMessage);
        writeTo(Patterns.REPORT_PATH,DateFormatter.getTime()+message);
        return message;
    }


        public void logDate(){
        writeFirst(Patterns.REPORT_PATH,DateFormatter.getTime());
}

    public void writeFirst(String path, String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))){

            writer.println(message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
