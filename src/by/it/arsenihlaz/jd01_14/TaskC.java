package by.it.arsenihlaz.jd01_14;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static by.it.arsenihlaz.jd01_14.Util.packagePath;

public class TaskC {
    public static void main(String[] args) {
        String txtFile = Util.getPath(TaskC.class, "resultTaskC.txt");
        System.out.println(packagePath());
        File packages = new File(packagePath());
        searchPackageAndFile(packages);
        writeFile(packages, txtFile);
    }

    private static void searchPackageAndFile(File packages) {
        for (File directory : packages.listFiles()) {
            if (!directory.isDirectory()) {
                System.out.println("file:" + directory.getName());
            } else if (directory.isDirectory()) {
                System.out.println("dir:" + directory.getName());
                searchPackageAndFile(directory);
            }
        }
    }

    private static void writeFile(File packages, String txtFile) {
        try (PrintWriter out = new PrintWriter(txtFile)) {
                out.println(packagePath());
            for (File directory : packages.listFiles()) {
                if (!directory.isDirectory()) {
                   out.println("file:" + directory.getName());
                } else if (directory.isDirectory()) {
                   out.println("dir:" + directory.getName());
                    writeFile(directory, txtFile);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
