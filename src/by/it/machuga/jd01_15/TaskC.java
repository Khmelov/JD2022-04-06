package by.it.machuga.jd01_15;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TaskC {

    public static final String MARKER = ">";
    public static final String END = "end";
    public static final String CD_PARENT = "cd ..";
    public static final String CD_CHILD = "cd ";
    public static final String DIR = "dir";
    public static final String NEW_LINE = "\n";
    public static final String FOLDER_CONTENT = "Folder content ";
    public static final String DIR_LABEL = "<DIR>";
    public static final String EMPTY_STRING = "";
    public static final String NO_SUCH_FILE_OR_FOLDER = "No such file or folder";
    public static final String QUOTE = "\"";
    public static final String INVALID_COMMAND = " is not an internal or external command, an executable program, or a batch file";
    public static final String INVALID_PATH = "The system cannot find the specified path";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = Util.getShortPath(TaskC.class);
        File currentDir = new File(path);
        System.out.print(currentDir.getAbsolutePath() + MARKER);
        String command = scanner.nextLine();
        while (!command.equals(END)) {
            if (command.equals(CD_PARENT)) {
                currentDir = openParentDir(currentDir);
            } else if (command.startsWith(CD_CHILD)) {
                String dirName = Util.getDirName(command);
                try {
                    currentDir = openDir(currentDir, dirName);
                } catch (IOException e) {
                    System.out.println(INVALID_PATH);
                }
            } else if (command.equals(DIR)) {
                printDirInfo(currentDir);
            } else {
                System.out.println(QUOTE + command
                        + QUOTE + INVALID_COMMAND);
            }
            System.out.print(NEW_LINE + currentDir.getAbsolutePath() + MARKER);
            command = scanner.nextLine();
        }
    }

    private static void printDirInfo(File currentDir) {
        System.out.println(FOLDER_CONTENT + currentDir.getAbsolutePath() + NEW_LINE);
        Calendar calendar = Calendar.getInstance();
        File[] files = currentDir.listFiles();
        if (files != null) {
            for (File file : files) {
                calendar.setTimeInMillis(file.lastModified());
                Date date = calendar.getTime();
                boolean isDir = file.isDirectory();
                long length = file.length();
                String name = file.getName();
                System.out.printf("%td.%tm.%tY %tH:%tM%9s%9d %s%n", date, date, date, date, date, isDir ? DIR_LABEL : EMPTY_STRING, length, name);
            }
        }
    }

    private static File openDir(File currentDir, String dirName) throws IOException {
        String dir = Util.appendPath(currentDir.getAbsolutePath(), dirName);
        File directory = new File(dir);
        if (!directory.exists()) {
            throw new IOException(NO_SUCH_FILE_OR_FOLDER);
        }
        return directory;
    }

    private static File openParentDir(File currentDir) {
        return currentDir.getParentFile();
    }
}
