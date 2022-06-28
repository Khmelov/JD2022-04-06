package by.it.machuga.jd01_15;

import java.io.*;

/**
 * no
 */
public class TaskB {

    public static final String TASK_B_JAVA = "TaskB.java";
    public static final String TASK_B_TXT = "TaskB.txt";
    public static final String CANNOT_WRITE_FILE = "Cannot write file";
    public static final char SLASH = '/';
    public static final char NEW_LINE = '\n';
    public static final char ASTERISK = '*';
    public static final String CANNOT_READ_FILE = "Cannot read file";

    public static void main(String[] args) {
        String source = Util.getPath(TaskB.class, TASK_B_JAVA);
        String destination = Util.getPath(TaskB.class, TASK_B_TXT);
        String text = readFile(source);
        System.out.println(text);
        writeToFile(text, destination);
    }

    private static void writeToFile(String text, String destination) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException(CANNOT_WRITE_FILE, e);
        }
    }

    private static String readFile(String source) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            int count = 0;
            StringBuilder tempBuilder = new StringBuilder();
            while (reader.ready()) {
                char symbol = (char) reader.read();
                if (symbol == SLASH && count == 0) {
                    tempBuilder.append(symbol);
//                    no comments
                    count++;
/*
 no comments
 */
                } else if (symbol == SLASH && count == 1) {
                    readOneLineComment(reader);
                    stringBuilder.append(NEW_LINE);
                    count = 0;
                    tempBuilder.delete(0, 1);
                } else if (symbol == ASTERISK && count == 1) {
                    readMultiLineComment(reader);
                    count = 0;
                    tempBuilder.delete(0, 1);
                } else {
                    stringBuilder.append(tempBuilder);
                    stringBuilder.append(symbol);
                    count = 0;
                    tempBuilder.delete(0, 1);
                }
            }
// no comments

        } catch (IOException e) {
            throw new RuntimeException(CANNOT_READ_FILE, e);
        }
        return stringBuilder.toString();
    }

    /*
     no comments
     */
    private static void readMultiLineComment(BufferedReader reader) throws IOException {
        int count = 0;
        while (reader.ready()) {
            char symbol = (char) reader.read();
            if (symbol == ASTERISK && count == 0) {
                count++;
            } else if (symbol == SLASH && count == 1) {
//                count++;
//            } else if (symbol == '\r' && count == 2) {
//                count++;
//            } else if (symbol == '\n' && count == 3) {
                break;
            } else {
                count = 0;
            }
        }
    }

    private static void readOneLineComment(BufferedReader reader) throws IOException {
        while (reader.ready()) {
            if ((char) reader.read() == NEW_LINE) {
                break;
            }
        }
    }
}
