package by.it.eivanova.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.util.Arrays;

public class TaskC {

    public static final String RESULT_TASK_C_TXT = "resultTaskC.txt";

    public static void main(String[] args) {
        //String pathBinaryFile = Util.getPath(TaskC.class, RESULT_TASK_C_TXT);
       // ArrayList<Integer> integers = readIntegers(pathBinaryFile);
       // writeIntegers(pathBinaryFile);
       // printToConsole(integers);


        //String pathTxtFile = Util.getPath(TaskC.class, RESULT_TASK_C_TXT);
        //writeIntegers(pathTxtFile);
        //ArrayList<Integer> integers = readIntegers(pathTxtFile);
        //printToTxtFile(integers, pathTxtFile);
        //printToConsole(integers);

        // ВЫВОД ПАПОК:
        File pathDir = null;
        String[] pathsFilesAndDir;
        try {
            pathDir = new File("E:\\it-academy\\jd2022-04-06\\out\\production\\jd2022-04-06\\by\\it\\eivanova");
            // Массив файлов и папок
            pathsFilesAndDir = pathDir.list();

            for (String path : pathsFilesAndDir) {
                // Вывод списка файлов и каталогов
                System.out.println("dir:" + path);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private static ArrayList<Integer> readIntegers(String path) {
        ArrayList<Integer> integers = new ArrayList<>();
        try (DataInputStream dataInputStream =
                     new DataInputStream(new BufferedInputStream(new FileInputStream(path)))
        ) {
            while (dataInputStream.available() > 0) {
                integers.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return integers;
    }



    private static void printToConsole(ArrayList<Integer> integers) {
        File pathDir = null;
        String[] pathsFilesAndDir;
        try {
            pathDir = new File("E:\\it-academy\\jd2022-04-06\\out\\production\\jd2022-04-06\\by\\it\\eivanova");
            // Массив файлов и папок
            pathsFilesAndDir = pathDir.list();

            for (String path : pathsFilesAndDir) {
                // Вывод списка файлов и каталогов
                System.out.println("dir:" + path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void printToTxtFile(ArrayList<Integer> integers, String txtFile) {
        File pathDir = null;
        String[] pathsFilesAndDir;
        try {
            pathDir = new File("E:\\it-academy\\jd2022-04-06\\out\\production\\jd2022-04-06\\by\\it\\eivanova");
            // Массив файлов и папок
            pathsFilesAndDir = pathDir.list();

            for (String path : pathsFilesAndDir) {
                // Вывод списка файлов и каталогов
                System.out.println("dir:" + path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}