package by.it.machuga.jd02_07.util;

import by.it.machuga.jd02_07.interfaces.Constants;

import java.io.File;

public class PathFinder {

    public static String getPath(Class<?> aClass, String filename) {
        String root = System.getProperty(Constants.USER_DIR);
        String relationPath = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root + File.separator + Constants.SRC + File.separator + relationPath + filename;
    }
}