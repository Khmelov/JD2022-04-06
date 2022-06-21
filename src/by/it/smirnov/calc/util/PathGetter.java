package by.it.smirnov.calc.util;

import by.it.smirnov.calc.constants.Wordings;

import java.io.File;

public class PathGetter {
    private PathGetter() {
    }

    public static String getPath(Class<?> aClass, String filename) {
        String root = System.getProperty(Wordings.USER_DIR);
        String relationPath = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root + File.separator + "src" + File.separator + relationPath + filename;
    }
}
