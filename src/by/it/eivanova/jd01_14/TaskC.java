package by.it.eivanova.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;


public class TaskC {

    public static final String DATA_TASK_A_BIN = "dataTaskA.bin";
    public static final String RESULT_TASK_C_TXT = "resultTaskC.txt";

    public static void main(String[] args) {

       // String pathBinaryFile = Util.getPath(TaskA.class, DATA_TASK_A_BIN);
      //  writeIntegers(pathBinaryFile);
       // ArrayList<Integer> integers = readIntegers(pathBinaryFile);
      //  printToConsole(integers);
       // String pathTxtFile = Util.getPath(TaskA.class, RESULT_TASK_C_TXT);
      //  printToTxtFile(integers, pathTxtFile);
      //  String hi = "hi";

        File currentDir = new File("E:\\it-academy\\jd2022-04-06\\out\\production\\jd2022-04-06\\by\\it\\eivanova");
        displayAllFilesDirectories(currentDir);
    }



    // Отображение все файлов и папок основной дирректории
            public static void displayAllFilesDirectories(File dir) {
                File[] files = dir.listFiles();
                for (File file : files) {
                    if (file.isDirectory()) {
                      //  System.out.println("dir: " + file.getCanonicalPath());
                        System.out.println("dir:" + file);
                        // Вывести файлы подкаталогов, ежели нужно: displayAllFilesDirectories(file);
                    }
                }
            }
    }