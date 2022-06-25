package by.it.arsenihlaz.Calculator.util;

import by.it.arsenihlaz.jd01_14.TaskC;

import java.io.File;

public class PathFinder {
    public static String getPath(Class<?> aClass, String filename) {
        String root = System.getProperty("user.dir");
        String relationPath = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root + File.separator + "src" + File.separator + relationPath + filename;
    }

    public static String packagePath() {
        String root = System.getProperty("user.dir");
        String relationPath = TaskC.class.getName()
                .replace(TaskC.class.getSimpleName(), "")
                .replace(".", File.separator);
        File path = new File(relationPath);
        String parent = path.getParent();
        return root + File.separator + "src" + File.separator + parent;
    }
}
