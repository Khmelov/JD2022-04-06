package by.it.kameisha.jd02_01;


import java.io.File;

public class Util {
    public static String getPath(Class<?> aClass, String filename) {
        String root = System.getProperty("user.dir");
        String relationPath = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root + File.separator + "src" + File.separator + relationPath + filename;
    }
}
