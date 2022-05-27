package by.it.kameisha.jd01_15;

import by.it.kameisha.jd01_14.Util;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        String pathClass = Util.getPath(TaskA.class, TaskA.class.getSimpleName() + ".java");
        String pathTxtFile = Util.getPath(TaskA.class, TaskA.class.getSimpleName() + ".txt");
        printClass(pathClass,pathTxtFile);
    }

    private static void printClass(String pathClass, String pathTxtFile) {
        try(BufferedReader reader = new BufferedReader(new FileReader(pathClass));
            PrintWriter writer = new PrintWriter(pathTxtFile)){
            while (reader.readLine()!=null){
                
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
