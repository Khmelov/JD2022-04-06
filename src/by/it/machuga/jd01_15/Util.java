package by.it.machuga.jd01_15;

import java.io.File;

public class Util {
    public static final String USER_DIR = "user.dir";
    public static final String EMPTY_STRING = "";
    public static final String DOT = ".";
    public static final String SRC = "src";
    public static final String CD = "cd ";

    public static String getPath(Class<?> aClass, String fileName) {
        String root = System.getProperty(USER_DIR);
        String relationPath = aClass.getName()
                .replace(aClass.getSimpleName(), EMPTY_STRING)
                .replace(DOT, File.separator);
        return root + File.separator + SRC + File.separator + relationPath + fileName;
    }

    public static String getShortPath(Class<?> aClass) {
        String root = System.getProperty(USER_DIR);
        String relationPath = aClass.getPackageName()
                .replace(DOT, File.separator);
        return root + File.separator + SRC + File.separator + relationPath;
    }

    public static String getDirName(String command) {
        return command.replace(CD,EMPTY_STRING);
    }

    public static String appendPath(String path, String dirName) {
        return path+File.separator+dirName;
    }
}
