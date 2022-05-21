package by.it.kameisha.jd01_14;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TaskB {
    public static final String POEM_TEXT = "Poem.text";

    public static void main(String[] args) {
        String path = Util.getPath(TaskB.class, POEM_TEXT);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while(bufferedReader.read()!=-1){
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
