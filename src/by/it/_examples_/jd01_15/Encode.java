package by.it._examples_.jd01_15;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

public class Encode {
    @SuppressWarnings("CharsetObjectCanBeUsed")
    //проверка какие доступны кодировки
    public static void main(String[] args) {


        //построение коллекции кодировок
        SortedMap<String, Charset> charsetsMap = Charset.availableCharsets();
        System.out.println("Charsets available: " + charsetsMap.size());
        //вывод семейства кодировки и ее видов
        for (String name : charsetsMap.keySet()) {
            Charset charset = charsetsMap.get(name);
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(" (");
            Iterator<String> aliases = charset.aliases().iterator();
            while (aliases.hasNext()) {
                sb.append(aliases.next());
                if (aliases.hasNext())
                    sb.append(",");
            }
            sb.append(")");
            System.out.println(sb.toString());
        }

        //откроем файл на чтение в кодировке Windows-1251 и сохраним в UTF-8
        //поток для файла ввода
        String src = System.getProperty("user.dir") + "/src/by/it/_examples_/jd01_15/";
        String fnr = src + "win1251.txt";
        String fnw = src + "utf-8.txt";
        try (   //используем Autoclose Java7+
                //создаем потоки, для чтения и записи
                FileInputStream rs = new FileInputStream(fnr);
                FileOutputStream rw = new FileOutputStream(fnw);

                //создаем символьные потоки для чтения и записи, каждый в своей кодировке
                BufferedReader reader = new BufferedReader(new InputStreamReader(rs, "cp1251"));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(rw, "utf-8"))
        ) {
            //перекодировка
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
                System.out.println(line);
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
