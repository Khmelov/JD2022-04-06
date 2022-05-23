package by.it.arsenihlaz.jd01_14;

import by.it._classwork_.jd01_14.TaskA;
import by.it._classwork_.jd01_14.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        System.out.println(packageWay());


        File packages = new File(packageWay());
        for (String pack : packages.list()) {
            System.out.println("dir:" + pack);
        }
        for (File directory : packages.listFiles()) {
            if (directory.isDirectory()) {
                for (String file : directory.list()) {
                    if (file.contains(".")) {
                        System.out.println("file:" + file);
                    } else {
                        System.out.println("dir:" + file);
                    }
                }
            }
            for (File subDirectory : directory.listFiles()) {
                if (subDirectory.isDirectory()) {
                for (String file : subDirectory.list()) {
                    if (file.contains(".")) {
                        System.out.println("file:" + file);
                    } else {
                        System.out.println("dir:" + file);
                    }
                }
            }
            }
        }


        String txtFile = Util.getPath(by.it.arsenihlaz.jd01_14.TaskA.class, "resultTaskC.txt");
        try (PrintWriter out = new PrintWriter(txtFile)) {
            out.println(packageWay());
            File packages2 = new File(packageWay());
            for (String pack : packages2.list()) {
                out.println("dir:" + pack);
            }
            for (File files : packages2.listFiles()) {
                if (files.isDirectory()) {
                    for (String file : files.list()) {
                        if (file.contains(".")) {
                            out.println("file:" + file);
                        } else {
                            out.println("dir:" + file);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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
