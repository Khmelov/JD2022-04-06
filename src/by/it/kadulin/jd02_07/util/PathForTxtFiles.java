package by.it.kadulin.jd02_07.util;

import by.it.kadulin.jd01_14.TaskA;

import java.io.File;
import java.nio.file.Path;

public class PathForTxtFiles {
    public static String getPath(Class<?> aClass, String filename) {
        String root = System.getProperty(TaskA.USER_DIR);
        String relationPath = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        String fullPath = root + File.separator + "src" + File.separator + relationPath;
        return Path.of(fullPath).getParent() + File.separator + "txtfiles" + File.separator + filename;
//        return root + File.separator + "src" + File.separator + relationPath + filename;
    }
}
