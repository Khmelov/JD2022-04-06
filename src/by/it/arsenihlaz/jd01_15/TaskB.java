package by.it.arsenihlaz.jd01_15;

import by.it.arsenihlaz.jd01_14.Util;

import java.io.*;
//fdgdfgfdgdgfg
/*
sdfsdfsf
       */

public class TaskB {

    public static void main(String[] args) {

        String pathFile = Util.getPath(TaskB.class, "TaskB.java");
        File thisFile = new File(pathFile);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(thisFile))) {
            printText(fileReader, stringBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringBuilder);
    }

    private static void readText(BufferedReader fileReader, StringBuilder stringBuilder) throws IOException {
        while (fileReader.ready()) {
            int symbol = fileReader.read();
            if ((char) symbol == '\n') {
                printText(fileReader, stringBuilder);
            }
        }
    }

    private static void readText2(BufferedReader fileReader, StringBuilder stringBuilder) throws IOException {
        while (fileReader.ready()) {
            int symbol = fileReader.read();
            if ((char) symbol == '*') {
                checkText2(fileReader, stringBuilder);
            }
        }
    }

    private static void checkText2(BufferedReader fileReader, StringBuilder stringBuilder) throws IOException {
        if (fileReader.read() == '/') {
            printText(fileReader, stringBuilder);
        } else readText2(fileReader, stringBuilder);
    }

    private static void checkText(BufferedReader fileReader, StringBuilder stringBuilder) throws IOException {
        if (fileReader.read() == '/') {
            readText(fileReader, stringBuilder);
        } else printText(fileReader, stringBuilder);
        if (fileReader.read() == '*') {
            readText2(fileReader, stringBuilder);
        } else printText(fileReader, stringBuilder);
    }

    private static void printText(BufferedReader fileReader, StringBuilder stringBuilder) throws IOException {
        while (fileReader.ready()) {
            int symbol = fileReader.read();
            stringBuilder.append((char) symbol);
            if ((char) symbol == '/') {
                checkText(fileReader, stringBuilder);
            }
        }
    }
}