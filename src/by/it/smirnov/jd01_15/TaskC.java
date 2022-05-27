package by.it.smirnov.jd01_15;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskC {

    private static Scanner scanner = new Scanner(System.in);
    private static String dir = "";
    private static String command = "";
    private static final String ERR = "не является внутренней или внешней\n" +
            "командой, исполняемой программой или пакетным файлом.";
    private static final String NO_DIR = "Системе не удается найти указанный путь.";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.ENGLISH);

    public static void main(String[] args) {
        dir = TaskA.getDir(TaskC.class);
        while (!command.equals("end")) {
            System.out.print(dir);
            command = enterCommand();
            if (command.startsWith("cd ")) reSetDir(command);
            else if (command.equals("dir")) printDirInfo(dir);
            else if (command.equals("end")) break;
            else System.out.printf("\"%s\" %s%n", command, ERR);
        }
    }

    private static void reSetDir(String command) {
        String[] dePath = command.split(" ");
        Path path = Paths.get(dePath[1]);
        if (path.isAbsolute() && Files.exists(path)) dir = path.toString() + File.separator;
        else if (!path.isAbsolute()) {
            path = Paths.get(dir, dePath[1]);
            if (Files.exists(path)) dir = path.toString() + File.separator;
            else System.out.println(NO_DIR);
        }
    }

    private static void printDirInfo(String dir) {
        System.out.printf(" Содержимое папки %s%n%n", dir);
        String name;
        Date date;
        String dirOrFile = "<DIR>";
        File file = new File(dir);
        File[] allFiles = file.listFiles();
        for (int i = 0; i < allFiles.length; i++) {
            long space = allFiles[i].length();
            name = allFiles[i].getName();
            date = new Date(allFiles[i].lastModified());
            String dateF = FORMATTER.format(date);
            if(allFiles[i].isDirectory()) System.out.printf("%s    %s          %s%n", dateF, dirOrFile, name);
            else if(allFiles[i].isFile()) System.out.printf("%s         %9d %s%n", dateF, space, name);
        }
        System.out.println();
    }

    private static String enterCommand() {
        return scanner.nextLine();
    }
}
