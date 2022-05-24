package by.it.ragach.jd01_14;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {


        String pathForTextFile = Util.getPath(TaskA.class,"Poem.txt");
        String getText = getText(pathForTextFile);
        System.out.println(getText);

  


    }

    private static String getText(String pathForTextFile) {
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(pathForTextFile)){
            while (fileReader.ready()){
                char t = (char)fileReader.read();
                sb.append(t);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}


