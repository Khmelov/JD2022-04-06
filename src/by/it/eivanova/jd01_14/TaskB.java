package by.it.eivanova.jd01_14;

import by.it.eivanova.jd01_06.Poem;

import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class TaskB {

    private static final String RESULT_TASK_B_TXT = "resultTaskB.txt";
    private static final String DATA_TASK_B_TXT = "resultTaskB";
    public String text = Poem.text;
    public static String[] words = {};
    public static int[] counts = {};

    //  В файле с текстом Poem.txt нужно подсчитать общее количество знаков препинания и слов
// Вывести результат на консоль в виде одной строки: words=123, punctuation marks=15
// Продублировать вывод в консоль в файл resultTaskB.txt

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);

        String pathBinaryFile = Util.getPath(TaskA.class, DATA_TASK_B_TXT);
        writeIntegers(pathBinaryFile);
        ArrayList<Integer> integers = readIntegers(pathBinaryFile);
        printToConsole(integers);
        String pathTxtFile = Util.getPath(TaskA.class, RESULT_TASK_B_TXT);
        printToTxtFile(integers, pathTxtFile);
        String hi = "hi";



        while (matcher.find()) {
            String word = matcher.group();
            process (word);
        }
        printResult();
    }

    private static void process(String word) {
        words = Arrays.copyOf(words, words.length+1);
        words[words.length-1] = word;
        counts = Arrays.copyOf(counts, counts.length+1);
        counts[counts.length-1] = 1;
    }

    private static void printResult() {
        String text = Poem.text;
            int before = text.length();
            int after = text.replaceAll("[(.:,-,!]", "").length();
            System.out.println("words=" + counts.length + "," + " " + "punctuation marks=" + (before - after));

    }





    private static void writeIntegers(String path) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(path)
                        )
                )
        )
        {
            for (int i = 0; i < 20; i++) {
                int value = ThreadLocalRandom.current().nextInt(0, 1000);
                dataOutputStream.writeInt(value);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Integer> readIntegers(String path) {
        ArrayList<Integer> integers = new ArrayList<>();
        try (DataInputStream dataInputStream =
                     new DataInputStream(new BufferedInputStream(new FileInputStream(path)))
        ) {
            while (dataInputStream.available() > 0) {
                integers.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return integers;
    }

    private static void printToConsole(ArrayList<Integer> integers) {
        double sum = 0;
        for (Integer integer : integers) {
           sum += integer;
            System.out.print(integer + " ");
        }
        System.out.println("\navg=" + sum / integers.size());
    }

    public static void printToTxtFile(ArrayList<Integer> integers, String txtFile) {
        try (PrintWriter out = new PrintWriter(txtFile)) {
            double sum2 = 0;
            for (Integer integer : integers) {
                sum2 += integer;
                out.print(integer + " ");
            }
            out.println("\navg=" + sum2 / integers.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
   }
}
