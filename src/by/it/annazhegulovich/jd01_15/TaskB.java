package by.it.annazhegulovich.jd01_15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TaskB {
    public static void main(String[] args) {
//комментарий 1;
        //комментарий 2;
        /* двустрочный
        комментарий 3*/

        /*трестрочный
        комментарий
        номер 4*/
        String pathFile = Path.getPath(TaskB.class,"TaskB");
        StringBuilder text = new StringBuilder(readFile(pathFile));
    }

    private static String readFile(String pathFile) {
        StringBuilder programFile = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))){
            while (reader.ready()){
                String line = reader.readLine();
                programFile.append(line).append('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException("io error", e);
        }
        return programFile.toString();
    }

}
