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