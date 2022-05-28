package by.it.eivanova.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
//import org.apache.commons.io.FileUtils;


public class TaskB {

    // В программе создайте хотя бы 5 разных комментариев: 2 однострочных, 2 многострочных и 1 JavaDoc
    // Программа должна прочитать свой собственный текст в переменную типа StringBuilder.
    // Читая программу необходимо удалить все возможные виды комментариев, не трогая остальное.
    // Результат вывести на консоль и в файл с тем же местоположением и именем, но с расширением txt, а не java.
    // Считайте, что комментарии внутри строки невозможны (s=“//так не бывает”) и внутри комментария тоже
    // bla… /*так не бывает*/ bla… //и так тоже bla… */ . Регулярные выражения использовать нельзя

        public static void main (String[]args) throws IOException {
            String fileName = "matrix.txt";
            // считываем содержимое файла в String с помощью BufferedReader
            String contents = readUsingBufferedReader(fileName);
            System.out.println(contents);
            System.out.println(contents.length());
        }

                // считываем содержимое файла в String с помощью BufferedReader
                private static String readUsingBufferedReader (String fileName) throws IOException {
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));
                    String line = null;
                    StringBuilder stringBuilder = new StringBuilder();
                    String ls = System.getProperty("line.separator");
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line);
                        stringBuilder.append(ls);
                    }

                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    return stringBuilder.toString();
                }

                // читаем файл в строку с помощью класса Files
                private static String readUsingFiles (String fileName) throws IOException {
                    return new String(Files.readAllBytes(Paths.get(fileName)));
                }




      //  int[][] matrix = createMatrix(ROWS, COLS, MIN_VALUE, MAX_VALUE);
      //  String filename = Util.getPath(TaskA.class, "matrix.txt");
      //  printMatrix(matrix, filename);
      //  String text = readFile(filename);
      //  System.out.println(text);
    }
