package by.it.smirnov.calc.util;

import by.it.smirnov.calc.ConsoleRunner;

import java.io.File;

public class PathGetter {

    public static String getPath(Class<?> aClass, String filename) {
        String root = System.getProperty(ConsoleRunner.USER_DIR);
        String relationPath = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root + File.separator + "src" + File.separator + relationPath + filename;
    }
}
