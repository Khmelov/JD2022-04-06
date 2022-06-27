package by.it.machuga.calc.util;

import java.io.File;

public class FileUtil {
    public static final String USER_DIR = "user.dir";
    public static final String EMPTY_STRING = "";
    public static final String DOT = ".";
    public static final String SRC = "src";

    public static String getPath(Class<?> aClass, String fileName) {
        String root = System.getProperty(USER_DIR);
        String relationPath = aClass.getName()
                .replace(aClass.getSimpleName(), EMPTY_STRING)
                .replace(DOT, File.separator);
        return root + File.separator + SRC + File.separator + relationPath + fileName;
    }

}
