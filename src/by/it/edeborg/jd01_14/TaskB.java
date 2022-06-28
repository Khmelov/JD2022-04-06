package by.it.edeborg.jd01_14;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String WORD = "[А-Яа-яЁё]+";
    public static final String PUNCTUATION_MARKS = "\\p{Punct}+";
    public static final String RESULT_TASK_B_TXT = "resultTaskB.txt";
    public static final String POEM_TXT = "Poem.txt";

    public static void main(String[] args) {

        String pathPoem = Util.getPath(TaskB.class, POEM_TXT);
        StringBuilder poem= getText(pathPoem);

        int words = countMatches(WORD, poem);
        int punctuationMarks = countMatches(PUNCTUATION_MARKS, poem);
        System.out.println("words="+words+", punctuation marks="+punctuationMarks);

        String pathResultTaskB = Util.getPath(TaskB.class, RESULT_TASK_B_TXT);
        printTxtFile(words, punctuationMarks, pathResultTaskB);

    }

    private static StringBuilder getText(String pathPoem) {
        StringBuilder poem= new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader(pathPoem))){
            while(bufferedReader.ready()){
                poem.append(bufferedReader.readLine()).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return poem;
    }

    public static int countMatches(String regex, CharSequence text){
        int result=0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            result++;
        }
        return result;
    }

    private static void printTxtFile(int words, int punctuationMarks, String pathResultTaskB) {
        try(PrintWriter out = new PrintWriter(pathResultTaskB)){
            out.println("words="+ words +", punctuation marks="+ punctuationMarks);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
