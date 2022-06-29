package by.it.kameisha.calc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataTime {
    static String showDateTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy"));
    }
}
