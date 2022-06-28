package by.it.selvanovich.jd01_15;

import by.it.selvanovich.jd01_14.Util;

import java.io.*;

/**
 * JavaDoc Тест
 * @author Данила Сельванович
 * @version 1.0
 **/

public class TaskB {
    /*
    Многострочный
    комментарий
     */
    public static final String pathTaskBClass = Util.getPath(TaskB.class, "TaskB.java");
    public static final String pathResultFile = Util.getPath(TaskB.class, "TaskB.txt");

    public static void main(String[] args) throws IOException {
        writeFile(readFile(pathTaskBClass));
    }

    //Метод для чтения файла
    public static String readFile(String path) {
        StringBuilder codeFile = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                codeFile.append(reader.readLine()).append('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException("io error", e);
        }
        return codeFile.toString()
                .replaceAll(Patterns.COMMENT_PATTERN, "");
    }

    //Метод для записи в файл
    public static void writeFile(String text) throws IOException {
        FileWriter writer = new FileWriter(pathResultFile);
        writer.write(text);
        writer.close();
    }
}
