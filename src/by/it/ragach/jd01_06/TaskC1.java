package by.it.ragach.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String text = Poem.text;
        String [] sentences = text.split("[\n]");


        int maxline = 0;

        for (String sentence : sentences) {
            if (maxline<sentence.length()) {
                maxline = sentence.length();
            }

        }
        System.out.println(maxline);


        }

}












