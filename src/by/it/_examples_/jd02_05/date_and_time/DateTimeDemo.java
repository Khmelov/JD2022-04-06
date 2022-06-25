package by.it._examples_.jd02_05.date_and_time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeDemo {
    public static void main(String[] args) {
        //глобальное время
        Instant instant = Instant.now();
        System.out.println(instant); //2021-12-10T21:58:35.675349300Z
        //полное время
        ZonedDateTime zonedDateTime = ZonedDateTime
                .ofInstant(instant, ZoneId.of("UTC+3"));
        //форматирование времени
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("HH.mm dd.MM.yyyy г.", new Locale("ru"));
        String stringTime = dateTimeFormatter
                .format(zonedDateTime);
        System.out.println(stringTime); //00.58 11.12.2021 г.
        //или наоборот парсинг
        LocalDateTime localDateTime = LocalDateTime.parse(stringTime, dateTimeFormatter);
        System.out.println(localDateTime); //2021-12-11T00:58
    }
}


