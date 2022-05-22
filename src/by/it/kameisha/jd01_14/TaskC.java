package by.it.kameisha.jd01_14;

import java.io.File;

public class TaskC {
    public static void main(String[] args) {
        String root = System.getProperty(TaskA.USER_DIR);
        String name = Util.getPath(TaskC.class,"");
        String newname = name.replace("jd01_14\\","");
        String path = "D:\\itacademy\\JD2022-04-06"+File.separator+"by"+File.separator+"it"+File.separator+"kameisha";
        File file = new File(newname);
        System.out.println(newname);
        System.out.println(file.isDirectory());
        File[] list = file.listFiles();
        for (File file1 : list) {
            if(file1.isDirectory()){
                System.out.println(" dir:"+file1.getName());
                for (File listFile : file1.listFiles()) {
                    System.out.println("file:"+listFile.getName());
                }
            }
        }
    }
}
