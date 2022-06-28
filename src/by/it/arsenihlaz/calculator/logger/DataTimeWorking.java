package by.it.arsenihlaz.calculator.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataTimeWorking {
    private static String dataTimeStart;
    private static String dataTimeEnd;

    public static void setDataTimeStart(String newDataTimeStart) {
        dataTimeStart = newDataTimeStart;
    }

    public static void setDataTimeEnd(String newDataTimeEnd) {
        dataTimeEnd = newDataTimeEnd;
    }

    public static String getDataTimeStart() {
        return dataTimeStart;
    }

    public static String getDataTimeEnd() {
        return dataTimeEnd;
    }

    public static String getDataTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM.yyyy HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
