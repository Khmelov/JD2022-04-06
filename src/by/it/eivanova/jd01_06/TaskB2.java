package by.it.eivanova.jd01_06;

public class TaskB2 {

    public static void main(String[] args) {
        String[] sentence = Poem.text.split("[.!]\\n");


        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = sentence[i].replaceAll("[^а-яА-ЯёЁ]+", " ");
            sentence[i] = sentence[i].trim();
        }


        for (int i = 0; i < sentence.length; i++) {
            for (int j = 0; j < sentence.length - 1; j++) {
                if(sentence[j].length() > sentence[j + 1].length()) {
                    String temp = sentence[j];
                    sentence[j] = sentence[j + 1];
                    sentence[j + 1] = temp;
                }
            }
        }


        for (String word : sentence) {
            System.out.println(word);
        }
    }
}
