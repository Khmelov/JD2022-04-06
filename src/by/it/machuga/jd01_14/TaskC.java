package by.it.machuga.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;

public class TaskC {

    public static final String OUTPUT_FILE = "resultTaskC.txt";
    public static final String FILE_PREFIX = "file:";
    public static final String DIR_PREFIX = "dir:";
    public static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        String path = Util.getShortPath(TaskC.class);
        File myPackage = new File(path);
        File[] files = myPackage.listFiles();
        StringJoiner stringJoiner = new StringJoiner(NEW_LINE);
        collectFilesInfo(files, stringJoiner);
        System.out.println(stringJoiner);
        String output = Util.getPath(TaskC.class, OUTPUT_FILE);
        printToFile(stringJoiner, output);
    }

    private static void printToFile(StringJoiner stringJoiner, String output) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            writer.write(stringJoiner.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void collectFilesInfo(File[] files, StringJoiner stringJoiner) {
        for (File file : files) {
            if (file.isFile()) {
                stringJoiner.add(FILE_PREFIX + file.getName());
            } else {
                stringJoiner.add(DIR_PREFIX + file.getName());
                File[] innerFiles = file.listFiles();
                collectFilesInfo(innerFiles, stringJoiner);
            }
        }
    }
}
