package by.it.selvanovich.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TaskC {
    public static final String RESULT_TASK_C_TXT = "resultTaskC.txt";
    public static final String pathTxtFileC = Util.getPath(TaskB.class, RESULT_TASK_C_TXT);
    public static String className = TaskC.class.getSimpleName();
    public static String path = Util.getPath(TaskC.class, TaskC.class.getSimpleName());
    public static File src = new File(path.replace("jd01_14" + File.separator + className, ""));
    public static List<String> fileDir = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File[] dirs = src.listFiles();
        for (File dir : dirs) {
            if (dir.isDirectory()) {
                fileDir.add("dir:" + dir.getName());
                System.out.println("dir:" + dir.getName());
                File folder = new File(dir.getCanonicalPath());
                File[] files = folder.listFiles();
                for (File file : files) {
                    fileDir.add("file:" + file.getName());
                    System.out.println("file:" + file.getName());
                }
            }
        }
        writeFile();
    }

    public static void writeFile() throws IOException {
        FileWriter writer = new FileWriter(pathTxtFileC);
        for (Object file : fileDir) {
            writer.write(file + System.lineSeparator());
        }
        writer.close();
    }

}
