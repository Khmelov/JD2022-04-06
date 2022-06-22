package by.it.smirnov.jd01_15;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Constants {
    private Constants() {
    }

    public static final String ERR = "\"%s\" не является внутренней или внешней\n" +
            "командой, исполняемой программой или пакетным файлом.%n";
    public static final String NO_DIR = "Системе не удается найти указанный путь.";
    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.ENGLISH);
    public static final String DIR_LINES = "%-20s%5s%9s %-25s%n";
    public static final String DIR_TITLE = " Содержимое папки %s%n%n";
    public static final String DIR_FLAG = "<DIR>";
    public static final String END = "end";
    public static final String THIS_DIR = "cd ";
    public static final String PARENT = "cd ..";
    public static final String DIR = "dir";
    public static final String DOT_1 = ".";
    public static final String DOT_2 = "..";
}
