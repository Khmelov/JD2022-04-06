package by.it.smirnov.jd01_15;

import java.io.File;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import static by.it.smirnov.jd01_15.Constants.*;
import static java.lang.System.in;
import static java.lang.System.out;

public class TaskC {

    public static void main(String[] args) {
        File dir = new File(TaskA.getDir(TaskC.class));
        Scanner scanner = new Scanner(in);
        String command = "";
        while (!command.equals(END)) {
            out.print(dir + ">");
            command = scanner.nextLine();
            if (command.equals(PARENT)) dir = dir.getParentFile();
            else if (command.startsWith(THIS_DIR)) dir = reSetDir(command, dir);
            else if (command.equals(DIR)) printDirInfo(dir);
            else if (command.equals(END)) break;
            else out.printf(ERR, command);
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
        out.printf(DIR_TITLE, file);
        String name;
        Date date;
        String dirOrFile = DIR_FLAG;
        File[] allFiles = file.listFiles();
        out.printf(DIR_LINES, FORMATTER.format(file.lastModified()), dirOrFile, "", DOT_1);
        out.printf(DIR_LINES, FORMATTER.format(file.getParentFile().lastModified()), dirOrFile, "", DOT_2);
        for (int i = 0; i < Objects.requireNonNull(allFiles).length; i++) {
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
