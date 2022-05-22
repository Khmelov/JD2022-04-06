package by.it.kameisha.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TaskC {

    public static final String RESULT_TASK_C_TXT = "resultTaskC.txt";

    public static void main(String[] args) {
        Class<TaskC> taskCClass = TaskC.class;
        String directoryPath = Util.getPath(taskCClass, "").replace("jd01_14\\", "");
        String resultPath = Util.getPath(taskCClass, RESULT_TASK_C_TXT);
        File directory = new File(directoryPath);
        printDirectory(directory);
        printTxtFile(resultPath, directory);
    }

    private static void printDirectory(File directory) {
        File[] files = directory.listFiles();
        for (File file : files != null ? files : new File[0]) {
            if (!file.isDirectory()) {
                System.out.println("file:" + file.getName());
            } else {
                System.out.println(" dir:" + file.getName());
                printDirectory(file);
            }
        }
    }

    private static void printTxtFile(String resultPath, File directory) {
        try (PrintWriter printWriter = new PrintWriter(resultPath)) {
            File[] files = directory.listFiles();
            for (File file : files != null ? files : new File[0]) {
                if (!file.isDirectory()) {
                    printWriter.println("file:" + file.getName());
                } else {
                    printWriter.println(" dir:" + file.getName());
                    printDirectory(file);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
