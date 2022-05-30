package by.it.marchenko.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class TaskC {
    public static final String DIR_PREFIX = "dir:";
    public static final String FILE_PREFIX = "file:";
    public static final String RESULT_FILE_NAME = "resultTaskC.txt";

    private static final LinkedList<String> fileTree = new LinkedList<>();

    public static void main(String[] args) {
        File rootFolder = Util.getRootFolderPath();
        LinkedList<String> fileTree = createFileTree(rootFolder);
        printFileTree(fileTree);
        String resultFile = Util.getFilePath(RESULT_FILE_NAME);
        printFileTree(resultFile, fileTree);
    }

    private static LinkedList<String> createFileTree(File rootFolder) {
        File[] files = rootFolder.listFiles();
        if (files == null) {
            throw new RuntimeException();
        }
        for (File file : files) {
            if (file.isDirectory()) {
                fileTree.addLast(DIR_PREFIX.concat(file.getName()));
                createFileTree(file);
            } else {
                fileTree.addLast(FILE_PREFIX.concat(file.getName()));
            }
        }
        return fileTree;
    }

    private static void printFileTree(LinkedList<String> fileTree) {
        for (String file : fileTree) {
            System.out.println(file);
        }
    }

    private static void printFileTree(String filePath, LinkedList<String> fileTree) {
        try (PrintWriter printWriter = new PrintWriter(filePath)) {
            for (String file : fileTree) {
                printWriter.println(file);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
