package by.it.smirnov.jd01_06;

public class TaskC2 {
    private static String[] words = Poem.text.split("[\\p{Punct}\\s]+");
    private static int[] random = new int[100000];


    public static void main(String[] args) {
        for (int i = 0; i < random.length; i++) {
            random[i] = (int)(Math.random() * words.length);
        }
        long startTime1=System.currentTimeMillis();
        String text = slow(Poem.text);
        long endTime1=System.currentTimeMillis();
        System.out.println("Время выполнения Slow = " + (endTime1 - startTime1));
        System.out.println(text);
        long startTime2=System.currentTimeMillis();
        String textFast = fast(Poem.text);
        long endTime2=System.currentTimeMillis();
        System.out.println("Время выполнения Fast = " + (endTime2 - startTime2));
        System.out.println(textFast);
    }

    private static String slow (String text) {
        int i = 0;
        String newText = "";
        while (newText.length() < 100000) {

            newText = newText + words[random[i]] + " ";
            i++;
        }
        return newText.trim();
    }

    private static String fast (String text) {
        int i = 0;
        StringBuilder newText = new StringBuilder("");
        while (newText.length() < 100000) {
            newText = newText.append(words[random[i]]).append(" ");
            i++;
        }
        return newText.toString().trim();
    }

}
