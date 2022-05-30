package by.it.smirnov.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.StringJoiner;

public class TaskC {
    private static final String SUB_DIR = "by.it.smirnov";
    private static final String FILE_RES = "resultTaskC.txt";
    private static StringJoiner filesAndDirs = new StringJoiner("\n");

    public static void main(String[] args) {
        File dir = new File(getDir(SUB_DIR));
        getAllDirFiles(dir);
        System.out.println(filesAndDirs.toString());
        writeToFile(filesAndDirs.toString());
    }

    private static void getAllDirFiles(File dir) {
        for (File fileEntry : Objects.requireNonNull(dir.listFiles())) {
            if (fileEntry.isDirectory()) {
                filesAndDirs.add("dir:" + fileEntry.getName());
                getAllDirFiles(fileEntry);
            } else {
                filesAndDirs.add("file:" + fileEntry.getName());
            }
        }
    }

    private static void writeToFile(String text) {
        try (PrintWriter writerTxt = new PrintWriter(new FileWriter(TaskA.getDir(TaskB.class) + FILE_RES))) {
            writerTxt.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDir(String subDir) {
        subDir = subDir.replace(".", File.separator);
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + subDir;
    }
}

