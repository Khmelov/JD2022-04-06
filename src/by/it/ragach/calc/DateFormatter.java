package by.it.ragach.calc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {


    public static String getDateTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss ");
        LocalDateTime ltd = LocalDateTime.now();
        return formatter.format(ltd);


    }

    public static String getDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDateTime ltd = LocalDateTime.now();
        return formatter.format(ltd);

    }

    public static String getTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss ");
        LocalDateTime ltd = LocalDateTime.now();
        return formatter.format(ltd);

    }
}
