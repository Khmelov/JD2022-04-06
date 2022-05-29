package by.it.avramchuk.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TaskC {

    public static final String RESULT_TASK_C_TXT = "resultTaskC.txt";

    public static void main(String[] args) {

        String property = System.getProperty(TaskA.USER_DIR);
        String path = property+File.separator+"src"+File.separator+
                "by"+File.separator+"it"+File.separator+"avramchuk";
        File fileName = new File(path);


        printContentConsole(fileName);
        String pathResultTaskC = Util.getPath(TaskC.class, RESULT_TASK_C_TXT);
        printContentToFileTxt(fileName, pathResultTaskC);


    }

    private static void printContentToFileTxt(File f, String pathResultTaskC) {
        try (PrintWriter out = new PrintWriter(pathResultTaskC)){

            if (f.isDirectory()) {
                File[] files = f.listFiles();
                assert files != null;
                for (File file : files) {
                    if (file.isDirectory()) {
                        out.println("dir:" + file.getName());
                        String[] list = file.list();
                        assert list != null;
                        for (String s : list) {
                            out.println("file:"+s);
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printContentConsole(File f) {
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            assert files != null;
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("dir:" + file.getName());
                    String[] list = file.list();
                    assert list != null;
                    for (String s : list) {
                        System.out.println("file:"+s);
                    }
                }
            }
        }
    }
}
