package by.it.arsenihlaz.jd01_15;

import by.it.arsenihlaz.jd01_14.Util;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        /*
        sdfsdfsf
         */
        String pathFile = Util.getPath(TaskB.class, "TaskB.java");
        File thisFile = new File(pathFile);
        try (FileInputStream fileInputStream = new FileInputStream(thisFile)) {
            char symbol = (char) fileInputStream.read();
            fileInputStream.mark(0);
            while (symbol != -1) {
                if (symbol == '/') {
                    fileInputStream.mark(symbol);
                    fileInputStream.read();
                    if (symbol == '*') {
    while (symbol!='*'){
        fileInputStream.skip(symbol);
    }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}