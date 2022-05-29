package by.it.avramchuk.jd01_14;

import java.io.File;

public class Util {
    public static String getPath (Class<?> taskClass,  String fileName) {
        String root = System.getProperty(TaskA.USER_DIR);
        String relationPath = taskClass.getName()
                .replace(taskClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root+File.separator+"src"+File.separator+relationPath+fileName;
    }
}
