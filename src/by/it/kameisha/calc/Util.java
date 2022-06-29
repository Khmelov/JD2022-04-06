package by.it.kameisha.calc;

import java.io.File;

public class Util {
    public static final String USER_DIR = "user.dir";

    public static String getPath(Class<?> aClass, String filename) {
        String root = System.getProperty(USER_DIR);
        String relationPath = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root + File.separator + "src" + File.separator + relationPath + filename;
    }
}
