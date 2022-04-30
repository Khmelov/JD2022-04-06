package by.it.avramchuk.jd01_06;

import java.util.Arrays;
import java.util.Comparator;


public class TaskB2 {
    public static Comparator<String> LenghthComparator = Comparator.comparingInt(String::length);

    public static void main(String[] args) {

        String[] sentencies = getSentArray(Poem.text);
        Arrays.sort(sentencies, LenghthComparator);
        printResult(sentencies);
    }

    private static String[] getSentArray(String text) {

        String s = text.replaceFirst("[.]{3,}", "    ");
        String[] sentencies = s.split("[.!]+");

        for (int i = 0; i < sentencies.length; i++) {
            sentencies[i] = sentencies[i].replaceAll("[^а-яА-ЯЁё]+", " ");

            sentencies[i]= sentencies[i].trim();
        }
        return sentencies;
    }

    private static void printResult(String[] sentencies) {

        for (String sentency : sentencies) {
            System.out.println(sentency);
        }
    }
}
