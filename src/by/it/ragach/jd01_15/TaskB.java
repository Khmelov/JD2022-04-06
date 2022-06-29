package by.it.ragach.jd01_15;

import by.it.ragach.jd01_14.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class TaskB {

    public static void main(String[] args) {
        String javaFile = Util.getPath(TaskB.class, "TaskB.java");
        StringBuilder withoutComments = new StringBuilder();
        readFile(withoutComments, javaFile);
        System.out.println(withoutComments);
        String txtFile = Util.getPath(TaskB.class, "TaskB.txt");
        printToFile(withoutComments, txtFile);
    }

    private static void printToFile(StringBuilder stringBuilder, String filename) {
        try {
            PrintWriter out = new PrintWriter(filename);
            out.print(stringBuilder);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("error io" + e);
        }

    }

    private static void readFile(StringBuilder stringBuilder, String filename) {
        try {
            RandomAccessFile sourceFile = new RandomAccessFile(filename, "r");
            long length = sourceFile.length();
            for (long pos = 0; pos < length; pos++) {
                sourceFile.seek(pos);
                char ch = (char) sourceFile.read();
                if ((String.valueOf(ch)).equals("/")) {
                    char nextCh = (char) sourceFile.read();
                    if ((String.valueOf(ch)).equals("*")) {
                        do {
                            nextCh = (char) sourceFile.read();
                        } while (!((String.valueOf(nextCh)).equals("/")));
                        pos = sourceFile.getFilePointer() - 1;
                    } else {
                        if (((String.valueOf(nextCh)).equals("/"))) {
                            do {
                                nextCh = (char) sourceFile.read();

                            } while (!((String.valueOf(nextCh)).equals("\n")));
                            pos = sourceFile.getFilePointer() - 2;
                        } else {
                            stringBuilder.append(ch);
                        }
                    }

                } else {
                    stringBuilder.append(ch);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("error io" + e);
        }


    }
}
