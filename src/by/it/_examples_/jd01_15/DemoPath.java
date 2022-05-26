package by.it._examples_.jd01_15;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DemoPath {
    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/by/it/akhmelev/";
        String fileInTxt = src + "jd0l_15/in.txt";
        // Создание объекта Path
        Path testFilePath = Paths.get(fileInTxt);
        //Вывод информации о файле
        System.out.println("Printing file information: ");
        System.out.println("\t file name: " + testFilePath.getFileName());
        System.out.println("\t root of the path: " + testFilePath.getRoot());
        System.out.println("\t parent of the target: "
                + testFilePath.getParent());
        //Вывод элементов пути
        System.out.println("Printing elements of the path: ");
        for (Path element : testFilePath) {
            System.out.println("\t path element: " + element);
        }
    }
}