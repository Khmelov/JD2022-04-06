package by.it.machuga.calc.util;

import by.it.machuga.calc.constans.ConstantStorage;

import java.io.File;

public class PathFinder {

    public static String getPath(Class<?> aClass, String filename) {
        String root = System.getProperty(ConstantStorage.USER_DIR);
        String relationPath = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root + File.separator + "src" + File.separator + relationPath + filename;
    }
}
