package by.it.selvanovich.jd01_15;

import by.it.selvanovich.jd01_14.Util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TaskC {
    public static String path = Util.getPath(TaskC.class, "");
    public static File src = new File(path);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        label:
        while (scanner.hasNext()) {
            String commandLine = scanner.nextLine();
            System.out.println(path + ">" + commandLine);
            String[] command = commandLine.split(" ");
            switch (command[0]) {
                case "end":
                    break label;
                case "dir":
                    showDir();
                    break;
                case "cd":
                    useCd(command);
                    break;
                default:
                    break;
            }
        }
    }

    public static void showDir() {
        File[] dirs = src.listFiles();
        if (dirs != null) {
            for (File dir : dirs) {
                String fileType = "";
                String fileSize = dir.length() + " byte";
                String fileName = dir.getName();
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy  HH:mm");
                String date = dateFormat.format(dir.lastModified());
                if (dir.isDirectory()) {
                    fileType = "<DIR>";
                    fileSize = "";
                }
                System.out.printf("%-21s%-5s%15s %-25s\n", date, fileType, fileSize, fileName);
            }
        }
    }

    public static void useCd(String[] command) {
        if (command[1].equals("..")) {
            path = path.replaceAll(Patterns.LAST_DIR, "");
        } else {
            path = path + command[1] + File.separator;
        }
        System.out.println(path);
        src = new File(path);
    }
}
