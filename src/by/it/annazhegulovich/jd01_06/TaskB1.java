package by.it.annazhegulovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {


    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[а-яA-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            check(word);

        }

    }

    private static void check(String word) {
        String glas = "аАуУоОиИэЭыяЯюЮеЕёЁ";
                for (int i = 0; i < word.length()-1; i++) {
                    if (glas.indexOf(word.charAt(0))==-1) {
                        if (glas.indexOf(word.charAt(word.length()-1))!=-1){
                            System.out.println(word);
                        return;
                        }
                   }

                }
            }
        }






