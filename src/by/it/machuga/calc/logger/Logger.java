package by.it.machuga.calc.logger;

import by.it.machuga.calc.interfaces.Log;
import by.it.machuga.calc.util.FileUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;

public enum Logger implements Log {
    INSTANCE;


    private void log(String message) {
        String path = FileUtil.getPath(Logger.class, "log.txt");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))) {
            printWriter.println(message);
        } catch (IOException e) {
           error(e.getMessage());
        }
    }

    @Override
    public void error(String message) {
        String time= ZonedDateTime.now().toString();
        String errorMessage=String.format("ERROR: %s %s",time,message);
        System.err.println(errorMessage);
        log(errorMessage);

    }

    @Override
    public void info(String message) {
        String time= ZonedDateTime.now().toString();
        String infoMessage=String.format("INFO: %s %s",time,message);
        System.out.println(infoMessage);
        log(infoMessage);

    }
}
