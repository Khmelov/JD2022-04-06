package by.it.ragach.jd01_14;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        String pathToBinaryFile = Util.getPath(TaskA.class,"Poem.txt");

        try (DataInputStream dataInputStream = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("Poem.txt"))
                    )
            ){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        double count = 0;




        }

    }

