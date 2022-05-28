package by.it.ragach.jd01_14;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TaskC {
    public static void main(String[] args) {
        String root = Util.getPath(TaskC.class,"user.dir");
        File project = new File(root);
        List<String> files = new ArrayList<>();
        List<String> catalogs = new ArrayList<>();
        File [] elements = project.listFiles();
        if (elements!=null){
            for (File nameElements:elements){
                if (nameElements.isFile()){
                    files.add(nameElements.getName());
                } else if (nameElements.isDirectory()){
                    catalogs.add(nameElements.getName());
                }
            }
            System.out.println("file"+files+"dir"+catalogs);

        } else {
            System.out.println("Файлов и каталогов нет");
        }

    }
}
