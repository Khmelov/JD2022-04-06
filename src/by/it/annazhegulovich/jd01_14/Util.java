package by.it.annazhegulovich.jd01_14;

import java.io.File;

public class Util {

        public static String getPath(Class<?> aClass, String filename) {
            String root = System.getProperty(TaskA.USER_DIR);   // путь к проекту
            String name = aClass.getName();
            String relPath = name.replace(aClass.getSimpleName(), "").replace(".", File.separator);
            String allPath = root+File.separator+"src"+File.separator+relPath; //полный путь к файду в данной папке
    return (allPath+filename);
        }
    }

