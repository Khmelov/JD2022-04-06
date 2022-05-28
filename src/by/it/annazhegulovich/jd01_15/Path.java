package by.it.annazhegulovich.jd01_15;

import java.io.File;

public class Path {
    public static final String USER_DIR = "user.dir";

    public static String getPath(Class<?> aClass, String fileName) {
        String dir = System.getProperty(USER_DIR);
        String path = aClass.getName().
                replace(aClass.getSimpleName(), "").
                replace(".", File.separator);
        String allPath = dir + File.separator + "src" + File.separator + path;
        System.out.println(allPath);
        return (allPath+fileName);
    }
}
