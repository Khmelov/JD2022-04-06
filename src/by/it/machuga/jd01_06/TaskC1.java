package by.it.machuga.jd01_06;

public class TaskC1 {

    public static void main(String[] args) {
        String[] line = Poem.text.split("\n");
        int maxLineLength = findMaxLineLength(line);
        addSpaces(line, maxLineLength);
    }

    private static int findMaxLineLength(String[] array) {
        int max = 0;
        for (String s : array) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    private static void addSpaces(String[] array, int max) {
        for (String s : array) {
            if (s.length() == max) {
                System.out.println(s);
            } else {
                String[] words = s.split(" ");
                int numberChars = countChars(words);
                int rowDifference = max - numberChars;
                int numberSpaces = rowDifference / (words.length - 1);
                int extraSpaces = rowDifference % (words.length - 1);
                joinWords(words, numberSpaces, extraSpaces);
            }
        }
    }

    private static void joinWords(String[] words, int numberSpaces, int extraSpaces) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            stringBuilder.append(words[i]);
            stringBuilder.append(" ".repeat(numberSpaces));
            if (extraSpaces > 0) {
                stringBuilder.append(" ");
                extraSpaces--;
            }
        }
        stringBuilder.append(words[words.length - 1]);
        System.out.println(stringBuilder);
    }

    private static int countChars(String[] words) {
        int sum = 0;
        for (String word : words) {
            sum += word.length();
        }
        return sum;
    }
}