package by.it.arsenihlaz.jd01_06;
/*
Разделить текст по строкам
узнать длину максимальной строки
находим индекс первого пробела
добавляем пробел, смещаемся дальше
когда закончилась строка повторяем
 */

public class TaskC1 {
    public static void main(String[] args) {
        String lines[] = Poem.text.split("[\n]");

        int maxLenght = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() > maxLenght) {
                maxLenght = lines[i].length();
            }
        }
        for (int i = 0; i < lines.length; i++) {
            String origin = lines[i];
            String result = addSpaces(origin, maxLenght);
            System.out.println(result);
        }
    }

    private static final String DELIMITER = " ";

    private static String addSpaces(String origin, int count) {
        StringBuilder line =  new StringBuilder(origin);
        int point = 0;
        while (line.length() < count) {
            int index = line.indexOf(DELIMITER, point);
            if (index == -1) {
                point = 0;
                continue;
            }
            point = index + DELIMITER.length();
            if (point == line.indexOf(DELIMITER, point)) {
                continue;
            }
            line.replace(point, point, DELIMITER);
            point += DELIMITER.length();
        }
        return line.toString();
    }
}
