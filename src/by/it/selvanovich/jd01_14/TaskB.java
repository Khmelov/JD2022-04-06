package by.it.selvanovich.jd01_14;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static Pattern punct = Pattern.compile("[(.:,-,!]");
    public static Pattern word = Pattern.compile("[а-яА-ЯёЁ]+");
    public static final String RESULT_TASK_B_TXT = "resultTaskB.txt";
    public static final String pathTxtFileB = Util.getPath(TaskB.class, RESULT_TASK_B_TXT);
    public static final String fin = Util.getPath(TaskB.class, "Poem.txt");


    public static void main(String[] args) throws IOException {
        int[] result = readFile();
        System.out.println("words=" + result[0] + ", punctuation marks=" + result[1]);
        writeFile(result);
    }

    public static int[] readFile() throws IOException {
        int[] result = new int[2];
        StringBuilder sb = new StringBuilder();
        FileReader reader = new FileReader(fin);
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNext()) {
            sb.append(scanner.next()).append(" ");
        }
        reader.close();
        Matcher puncts = punct.matcher(sb);
        while (puncts.find()) {
            result[1]++;
        }
        Matcher words = word.matcher(sb);
        while (words.find()) {
            result[0]++;
        }
        return result;

    }

    public static void writeFile(int[] result) throws IOException {
        FileWriter writer = new FileWriter(pathTxtFileB);
        writer.write("words=" + result[0] + ", punctuation marks=" + result[1]);
        writer.close();
    }
}
