package by.it.arsenihlaz.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static by.it.arsenihlaz.jd01_14.Util.packagePath;

public class TaskC implements Constant {

    public static void main(String[] args) {
        String txtFile = Util.getPath(TaskC.class, RESULT_TASKC_TXT);
        System.out.println(packagePath());
        File packages = new File(packagePath());
        searchPrintConsole(packages);
        searchPrintFile(txtFile, packages);
    }

    private static void searchPrintFile(String txtFile, File packages) {
        try (PrintWriter out = new PrintWriter(txtFile)) {
            out.println(packagePath());
            writeFile(packages, out);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void searchPrintConsole(File packages) {
        for (File directory : packages.listFiles()) {
            if (!directory.isDirectory()) {
                System.out.println(FILE + directory.getName());
            } else if (directory.isDirectory()) {
                System.out.println(DIR + directory.getName());
                searchPrintConsole(directory);
            }
        }
    }

    private static void writeFile(File packages, PrintWriter out) {
        for (File directory : packages.listFiles()) {
            if (!directory.isDirectory()) {
                out.println(FILE + directory.getName());
            } else if (directory.isDirectory()) {
                out.println(DIR + directory.getName());
                writeFile(directory, out);
            }
        }
    }
}
