package by.it.ragach.jd01_06;


public class TaskC1 {
    public static void main(String[] args) {
        String text = Poem.text;
        String[] lines = text.split("\n"); //разбиваем по переводу строки текст
        int maxLine = 0; //максимальная длина строки

        for (String line : lines) {
            if (maxLine < line.length()) {
                maxLine = line.length();
            }

        }
        for (String line : lines) {
            String[] words = line.split("\s");//разбиваем строки на массив слов
            int spaceForAdd = maxLine - line.length(); //количество нехватающих пробелов
            int amountOfSpace = spaceForAdd / (words.length - 1); //целая часть при делении укажет колиество пробелов между всеми словами в строке
            String linesWithSpaces = "";
            int amountOfSpaceForAdd = spaceForAdd % (words.length - 1); //указывает сколько пробелов надо добавить
            String spaceLine = " ";
            for (int i = 0; i < amountOfSpace; i++) {
                spaceLine += " ";


            }
            for (int i = 0; i < words.length; i++) {
                if (i != words.length - 1) {
                    linesWithSpaces = linesWithSpaces + words[i] + spaceLine;
                    if (i < amountOfSpaceForAdd) {
                        linesWithSpaces += " ";
                    }
                } else {
                    linesWithSpaces = linesWithSpaces + words[i];
                }

            }
            System.out.println(linesWithSpaces);


        }


    }


}














