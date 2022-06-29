package by.it.kadulin.jd01_14;

import by.it._classwork_.jd01_14.TaskA;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskC {

    public static final String USER_DIR = "user.dir";
    public static List<String> listOfFiles = new ArrayList<>();
    public static List<String> listOfDirs = new ArrayList<>();
//    public static String mainDirectory = "";
//
//    static void setMainDirectory(String path) {
//        mainDirectory = path;
//    }

    public static void main(String[] args) {
        String root = System.getProperty(USER_DIR);
        Path path = Path.of(TaskC.class.getName()
                .replace(TaskC.class.getSimpleName(), "")
                .replace(".", File.separator)).getParent();

        String mainDir = root + File.separator + "src" + File.separator + path.toString();
        Path dirForProcess = Path.of(mainDir);
        File fileProcess = dirForProcess.toFile();
        searchingFiles(fileProcess);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Util.getPath(TaskB.class, "resultTaskC.txt")))) {
            for (String listOfFile : listOfFiles) {
                System.out.printf("file:%s%n", listOfFile);
                writer.write(String.format("file:%s%n", listOfFile));
            }

            for (String listOfDirs : listOfDirs) {
                System.out.printf("dir:%s%n", listOfDirs);
                writer.write(String.format("dir:%s%n", listOfDirs));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        printContent(listOfDirs, "dir:");
        printContent(listOfFiles, "file:");


//        setMainDirectory(mainDir);
//
//        try {
//            Files.walkFileTree(Paths.get(root + File.separator + "src" + File.separator + path), new MyFileVisitor());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PathFinder.getPath(TaskB.class, "resultTaskC.txt")))) {
//            for (String listOfFile : listOfFiles) {
//                System.out.printf("file:%s%n", listOfFile);
//                writer.write(String.format("file:%s%n", listOfFile));
//            }
//
//            for (String listOfDirs : listOfDirs) {
//                System.out.printf("dir:%s%n", listOfDirs);
//                writer.write(String.format("dir:%s%n", listOfDirs));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void printContent(List<String> list, String s) {
        for (String content : list) {
            System.out.println(s + content);
        }
    }

    private static void searchingFiles (File path) {
        if (path.isFile()) {
            listOfFiles.add(path.getName());
        }
        else if (path.isDirectory()) {
            listOfDirs.add(path.getName());
            File[] files = path.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    listOfFiles.add(file.getName());
                }
                else if (file.isDirectory()) {
                    searchingFiles(file);
                }
            }
        }

    }

//    private static class MyFileVisitor extends SimpleFileVisitor<Path>{
//        @Override
//        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//            listOfFiles.add(file.getFileName().toString());
//            return FileVisitResult.CONTINUE;
//        }
//
//        @Override
//        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//            Path relative = Path.of(mainDirectory).relativize(dir);
//            listOfDirs.add(relative.toString());
//            return FileVisitResult.CONTINUE;
//        }
//    }
}
