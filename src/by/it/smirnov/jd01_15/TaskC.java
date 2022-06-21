package by.it.smirnov.jd01_15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class TaskC {

    private static final String ERR = "не является внутренней или внешней\n" +
            "командой, исполняемой программой или пакетным файлом.";
    private static final String NO_DIR = "Системе не удается найти указанный путь.";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.ENGLISH);
    private static final String DIR_LINES = "%-20s%5s%9s %-25s%n";

    public static void main(String[] args) {
        File dir = new File(TaskA.getDir(TaskC.class));
        Scanner scanner = new Scanner(in);
        String command = "";
        while (!command.equals("end")) {
            out.print(dir + ">");
            command = scanner.nextLine();
            if (command.equals("cd ..")) dir = dir.getParentFile();
            else if (command.startsWith("cd ")) dir = reSetDir(command, dir);
            else if (command.equals("dir")) printDirInfo(dir);
            else if (command.equals("end")) break;
            else out.printf("\"%s\" %s%n", command, ERR);
        }
    }

    private static File reSetDir(String command, File dir) {
        String[] dePath = command.split(" ");
        String path = dePath[1];
        String newPath = dir.getAbsolutePath() + File.separator + path;
        File newFile = new File(newPath);
        if (newFile.exists()) dir = newFile;
        else out.println(NO_DIR);
        return dir;
    }

    private static void printDirInfo(File file) {
        out.printf(" Содержимое папки %s%n%n", file);
        String name;
        Date date;
        String dirOrFile = "<DIR>";
        File[] allFiles = file.listFiles();
        out.printf(DIR_LINES, FORMATTER.format(file.lastModified()), dirOrFile, "", ".");
        out.printf(DIR_LINES, FORMATTER.format(file.getParentFile().lastModified()), dirOrFile, "", "..");
        for (int i = 0; i < allFiles.length; i++) {
            long space = allFiles[i].length();
            name = allFiles[i].getName();
            date = new Date(allFiles[i].lastModified());
            String dateF = FORMATTER.format(date);
            if (allFiles[i].isDirectory()) out.printf(DIR_LINES, dateF, dirOrFile, "", name);
            else if (allFiles[i].isFile()) out.printf(DIR_LINES, dateF, "", space, name);
        }
        out.println();
    }
}
