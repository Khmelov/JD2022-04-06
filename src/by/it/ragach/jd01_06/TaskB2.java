package by.it.ragach.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        String text2 = text.replaceAll("[-:,\n ]+"," ");
        String [] sentenses = text2.split("[.!]");

        for (int i = 0; i < sentenses.length; i++) {
           sentenses[i]= sentenses[i].trim();
            System.out.println(sentenses[i]);

        }



    }
}
