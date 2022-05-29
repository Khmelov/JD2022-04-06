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
            int nextSymbol = fileReader.read();
            while (nextSymbol != -1) {
                printText(fileReader, stringBuilder);

                if ((char) nextSymbol == '/') {
                    if ((char) nextSymbol == '/') {
                        do {
                            printText(fileReader, stringBuilder);
                        }
                        while ((char) nextSymbol != '\n');
                    }
                    if ((char) nextSymbol == '*') {
                        do {
                            readText(fileReader);
                        }
                        while ((char) nextSymbol != '*');
                        if ((char) nextSymbol == '/') {
                            printText(fileReader, stringBuilder);
                        }
                    }
                } else printText(fileReader, stringBuilder);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringBuilder);
    }

    private static char readText(BufferedReader fileReader) throws IOException {
        char nextSymbol = (char) fileReader.read();
        return nextSymbol;
    }


    private static void printText(BufferedReader fileReader, StringBuilder stringBuilder) throws IOException {
        int symbol = fileReader.read();
        stringBuilder.append((char) symbol);
    }
}