package by.it.machuga.jd01_12;

import java.util.*;

public class TaskC1 {

    public static final String END = "end";
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Map<Integer, String> words = getWords();
        System.out.println(words);
        compressMap(words);
        System.out.println(words);
    }

    private static void compressMap(Map<Integer, String> words) {
        Map<Integer, String> wordsClone = new TreeMap<>();
        wordsClone.putAll(words);
        Iterator<Map.Entry<Integer, String>> iterator = wordsClone.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            String value = entry.getValue();
            if (Collections.frequency(wordsClone.values(), value) > 1) {
                removeDuplicates(words, value);
            }
        }
    }

    private static Map<Integer, String> getWords() {
        Map<Integer, String> words = new TreeMap<>();
        int index = 1;
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (!word.equals(END)) {
                words.put(index, word);
                index++;
            } else {
                break;
            }
        }
        return words;
    }

    private static void removeDuplicates(Map<Integer, String> words, String value) {
        Iterator<Map.Entry<Integer, String>> iterator = words.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            if (entry.getValue().equals(value)) {
                i++;
                if (i > 1) {
                    iterator.remove();
                }
            }
        }
    }
}
