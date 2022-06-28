package by.it.annazhegulovich.jd02_06;


import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class Runner {

    public static final String HELLO = "Hello";

    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        logger.log(HELLO);

        String dT = getDT();

        for (int i = 0; i < 5; i++) {
            new Worker("thread" + i + " - " + dT).start();
        }
    }

    private static String getDT() {
        Instant instant= Instant.now();
        ZonedDateTime zone =ZonedDateTime.ofInstant(instant, ZoneId.of("GMT+3")) ;
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("HH:mm dd:MM:yyyy");
        return dateTime.format(zone);
    }
}

    class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }


        @Override
        public void run() {
            Logger.getInstance().log(this.getName());
        }
    }

