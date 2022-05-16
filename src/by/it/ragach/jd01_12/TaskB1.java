package by.it.ragach.jd01_12;



import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB1 {
    public static void main(String[] args) {
        String values = "crocodile cat cat cat cat dog dog don't cat frog mouse pig Horse horse elephant end";
        Scanner scanner = new Scanner(values);
        Map<String,Integer> wordToCount = new HashMap<>();
        for(String word: values.split(" ")) {
            if (!word.equals("end")) {
                if (wordToCount.containsKey(word)) {
                    wordToCount.put(word, wordToCount.get(word) + 1);
                } else {
                    wordToCount.put(word, 1);
                }
            } else {
                break;
            }
        }

        Set<Map.Entry<String,Integer>> setWord = wordToCount.entrySet();
        Iterator<Map.Entry<String,Integer>>iWord = setWord.iterator();
        while (iWord.hasNext()){
            Map.Entry<String,Integer>me =iWord.next();
            System.out.println(me.getKey()+"="+me.getValue());

        }
        System.out.println(values);

    }
}



