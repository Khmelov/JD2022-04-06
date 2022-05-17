package by.it.ragach.jd01_12;



import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class TaskB1 {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);


            Map<String, Integer> wordToCount = new HashMap<>();
            while (scanner.hasNext()) {
                String value = scanner.nextLine();
                for (String word : value.split("[^a-zA-Z']+")) {
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

                Set<Map.Entry<String, Integer>> setWord = wordToCount.entrySet();
                Iterator<Map.Entry<String, Integer>> iWord = setWord.iterator();
                while (iWord.hasNext()) {
                    Map.Entry<String, Integer> me = iWord.next();
                    System.out.println(me.getKey() + "=" + me.getValue());

                }
            }
        }
    }







