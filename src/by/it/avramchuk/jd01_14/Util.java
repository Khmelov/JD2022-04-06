package by.it.avramchuk.jd01_14;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String getPath (Class<?> taskClass,  String fileName) {
        String root = System.getProperty(TaskA.USER_DIR);
        String relationPath = taskClass.getName()
                .replace(taskClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root+File.separator+"src"+File.separator+relationPath+fileName;
    }
    public static String getPath (Class<?> taskClass) {
        String root = System.getProperty(TaskA.USER_DIR);
        String relationPath = taskClass.getName()
                .replace(taskClass.getSimpleName(), "")
                .replace(".", File.separator);
        String result= root+File.separator+"src"+File.separator+relationPath;
        result=result.substring(0,result.length()-1);
        return result;
    }
    public static String getModifiedTime (File fileName){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long modifiedTime = fileName.lastModified();
        Date d = new Date(modifiedTime);
        return format.format(d);
    }
}
