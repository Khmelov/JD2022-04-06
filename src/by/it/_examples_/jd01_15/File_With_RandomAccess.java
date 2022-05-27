package by.it._examples_.jd01_15;

import java.io.IOException;
import java.io.RandomAccessFile;

public class File_With_RandomAccess {
    public static void main(String[] args) throws IOException {

        String src = System.getProperty("user.dir") + "/src/by/it/_examples_/";
        String fileInTxt = src + "jd01_15/random.dat";
        //запись
        RandomAccessFile file = new RandomAccessFile(fileInTxt, "rw");
        String abc = "abcdefgh";
        //строка переведена в массив байтов
        file.write(abc.getBytes());
        //закрываем файл
        file.close();
        //переоткроем, прочитаем. НАЙДИТЕ ОШИБКИ В КОДЕ (их несколько)
        file = new RandomAccessFile(fileInTxt, "r");
        long n = file.length();
        StringBuilder sb = new StringBuilder();
        for (long position = n - 1; position >= 0; position--) {
            file.seek(position);
            sb.append((char) file.read());
        }
        file.close();
        System.out.println(sb);
    }
}