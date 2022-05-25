package by.it.kudelko.jd01_14;

import java.io.File;

public class TaskA {

    public static final String USER_DIR = "user.dir";

    public static void main(String[] args) {
        String path = getPath(TaskA.class, "dataTaskA.bin");

    }

    public static String getPath(Class<?> aClass, String filename) {
        String root = System.getProperty(USER_DIR);
        System.out.println(root);
        Class<TaskA> taskAClass = TaskA.class;
        String name = taskAClass.getName();
        String relationPath = name.replace(taskAClass.getSimpleName(), "").replace(".", File.separator);
        String fullPath = root + File.separator + "src" + File.separator + relationPath;
        System.out.println(fullPath);
    }
}
