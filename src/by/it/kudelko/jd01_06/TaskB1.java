package by.it.kudelko.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        String[] words = Poem.text.split("[\\p{Punct}\\s]");
        String[] glasn = {"А", "а", "Я", "я", "О", "о", "Ё", "ё", "У", "у", "Ю", "ю", "Ы", "ы", "И", "и", "Э", "э", "Е", "е"};

        for (int j = 0; j < words.length; j++) {
            for (int i = 0; i < glasn.length; i++) {
                if(words[j].startsWith(glasn[i]) || words[j].equals(glasn[i])) {
                    j++;
                    break;
                }
            }
            for (int i = 0; i < glasn.length; i++) {
                if(words[j].endsWith(glasn[i])) {
                    System.out.println(words[j]);
                }
            }
        }
    }
}

