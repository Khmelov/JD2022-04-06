package by.it.machuga.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String INPUT_FILE_NAME = "Poem.txt";
    public static final String WORD = "[а-яА-ЯёЁ]+";
    public static final String PUNCTUATION_MARKS = "[-.!,?:]+";
    public static final String OUTPUT_FILE_NAME = "resultTaskB.txt";
    public static final String OUTPUT_TEXT = "words=%d, punctuation marks=%d";

    public static void main(String[] args) {
        String input = Util.getPath(TaskB.class, INPUT_FILE_NAME);
        String line;
        int wordsCount = 0;
        int punctuationMarksCount = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            while ((line = bufferedReader.readLine()) != null) {
                punctuationMarksCount += countMatches(line, PUNCTUATION_MARKS);
                wordsCount += countMatches(line, WORD);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = String.format(OUTPUT_TEXT, wordsCount, punctuationMarksCount);
        System.out.println(result);
        String output = Util.getPath(TaskB.class, OUTPUT_FILE_NAME);
        printToFile(result, output);
    }

    private static void printToFile(String result, String output) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))) {
            bufferedWriter.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countMatches(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList.size();
    }
}
