package by.it.smirnov.jd02_07.utils;



import by.it.smirnov.jd02_07.constants.Constants;

import java.io.File;

public class PathGetter {
    private PathGetter() {
    }

    public static String getPath(Class<?> aClass, String filename) {
        String root = System.getProperty(Constants.USER_DIR);
        String relationPath = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root + File.separator + "src" + File.separator + relationPath + filename;
    }
}
