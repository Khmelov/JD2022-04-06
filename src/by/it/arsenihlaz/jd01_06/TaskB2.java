package by.it.arsenihlaz.jd01_06;

import java.util.Arrays;
/*
Разделить текст на предложение и в массив
заменить символы на пробелы в предложениях массива + трим
посчитать длины подмассивов
отсортировать
 */

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text.replace("...", " ");
        String sentences[] = text.split("[.!?]\\s*");
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replaceAll("[^А-Яа-яЁё]+", " ");
            sentences[i] = sentences[i].trim();
        }
        sortArray(sentences);
        printArray(sentences);
    }

    static void sortArray(String[] array) {
        String temp = null;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].length() > array[j].length()) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    static void printArray(String[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}



