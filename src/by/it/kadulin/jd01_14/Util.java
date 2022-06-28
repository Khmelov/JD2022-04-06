package by.it.kadulin.jd01_14;

import java.io.File;

public class Util {
    public static String getPath(Class<?> aClass, String filename) {
        String root = System.getProperty(TaskA.USER_DIR);
        String relationPath = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root + File.separator + "src" + File.separator + relationPath + filename;
    }
}
