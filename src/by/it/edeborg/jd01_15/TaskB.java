package by.it.edeborg.jd01_15;

import by.it.edeborg.jd01_14.Util;

import java.io.*;

public class TaskB {

    public static void main(String[] args) {
        String pathFile = Util.getPath(TaskB.class, "TaskB.java");
        File thisFile = new File(pathFile);
        StringBuilder stringBuilder = new StringBuilder();
        try (RandomAccessFile fileReader = new RandomAccessFile(thisFile, "r")) {
            fileReader.seek(0);
            printText(fileReader, stringBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String txtFile = Util.getPath(TaskB.class, "TaskB.txt");
        printTxtFile(stringBuilder, txtFile);
    }

    private static void printText(RandomAccessFile fileReader, StringBuilder stringBuilder) throws IOException {
        while (fileReader.getFilePointer() != fileReader.length()) {
            int symbol = fileReader.read();
            stringBuilder.append((char) symbol);
            if ((char) symbol == '/') {
                checkText(fileReader, stringBuilder);
            }
        }
    }

    private static void checkText(RandomAccessFile fileReader, StringBuilder stringBuilder) throws IOException {
        int nextSymbol = fileReader.read();
        if (nextSymbol == '/') {
            fileReader.seek(fileReader.getFilePointer() - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            readText(fileReader, stringBuilder);
        } else if (nextSymbol == '*') {
            fileReader.seek(fileReader.getFilePointer() - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            readText2(fileReader, stringBuilder);
        } else fileReader.seek(fileReader.getFilePointer() - 1);
        printText(fileReader, stringBuilder);
    }

    private static void readText(RandomAccessFile fileReader, StringBuilder stringBuilder) throws IOException {
        while (fileReader.getFilePointer() != fileReader.length()) {
            int nextSymbol = fileReader.read();
            if (nextSymbol == '\n') {
                fileReader.seek(fileReader.getFilePointer() - 1);
                printText(fileReader, stringBuilder);
            }
        }
    }

    private static void checkText2(RandomAccessFile fileReader, StringBuilder stringBuilder) throws IOException {
        if (fileReader.read() == '/') {
            printText(fileReader, stringBuilder);
        } else
            readText2(fileReader, stringBuilder);
    }

    private static void readText2(RandomAccessFile fileReader, StringBuilder stringBuilder) throws IOException {
        while (fileReader.getFilePointer() != fileReader.length()) {
            int nextSymbol = fileReader.read();
            if (nextSymbol == '*') {
                checkText2(fileReader, stringBuilder);
            }
        }
    }

    private static void printTxtFile(StringBuilder stringBuilder, String txtFile) {
        try (PrintWriter out = new PrintWriter(txtFile)) {
            out.println(stringBuilder);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
