package by.it.machuga.jd01_06;

public class TaskB2 {

    public static final String THREE_DOTS = "...";
    public static final String SENTENCE_ENDING = "[.!]";
    public static final String NON_LETTER_SYMBOLS = "[^а-яА-ЯёЁ]+";
    public static final String NO_SPACE = "";
    public static final String SPACE = " ";

    public static void main(String[] args) {
        String text = Poem.text;
        String[] sentences = getSentences(text);
        removePunctuation(sentences);
        sort(sentences);
        printSentences(sentences);
    }

    private static String[] getSentences(String text) {
        text = text.replace(THREE_DOTS, NO_SPACE);
        return text.split(SENTENCE_ENDING);
    }

    private static void removePunctuation(String[] sentences) {
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replaceAll(NON_LETTER_SYMBOLS, SPACE);
            sentences[i] = sentences[i].trim();
        }
    }

    private static void printSentences(String[] sentences) {
        for (String element : sentences) {
            System.out.println(element);
        }
    }

    private static void sort(String[] sentences) {
        for (int i = 0; i < sentences.length; i++) {
            for (int j = i + 1; j < sentences.length; j++) {
                if (sentences[i].length() > sentences[j].length()) {
                    String temp = sentences[j];
                    sentences[j] = sentences[i];
                    sentences[i] = temp;
                }
            }
        }
    }
}
