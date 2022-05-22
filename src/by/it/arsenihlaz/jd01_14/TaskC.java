package by.it.arsenihlaz.jd01_14;

import by.it._classwork_.jd01_14.TaskA;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskC {
    public static void main(String[] args) {
        System.out.println(packageWay());
        File packages = new File(packageWay());
        System.out.println(Arrays.toString(packages.list()));
       // System.out.println(Arrays.toString(packages.listFiles()));

        List<File> list = new ArrayList<>();
        for (File file : packages.listFiles()) {
            if (file. isDirectory()){
                System.out.println(Arrays.toString(file.list()));
            }

        }

        System.out.println(list);
    }

    private static String packageWay() {
        String root = System.getProperty(TaskA.USER_DIR);
        String relationPath = TaskC.class.getName()
                .replace(TaskC.class.getSimpleName(), "")
                .replace(".", File.separator);
        File path = new File(relationPath);
        String parent = path.getParent();
        return root + File.separator + "src" + File.separator + parent;
    }
}
