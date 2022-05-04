package by.it.annazhegulovich.jd01_06;


import java.util.Arrays;

public class TaskB2 {


    public static void main(String[] args) {

        String copyPoem = new String(Poem.text);
        String[] sym= {",","!","\n","...",":"," -"};
        for (int i = 0; i < sym.length; i++) {
            if (i==2) {
                copyPoem = copyPoem.replace(sym[i], " ");
            }else copyPoem = copyPoem.replace(sym[i], "");
        }

        String[] parts= copyPoem.split("[.]");
        for (int i = 0; i < parts.length; i++) {
            parts[i]=parts[i].trim();
            System.out.println(parts[i]);
        }
        Arrays.sort(parts, (o1, o2) -> o1.length() - o2.length());
        for (String el:parts) {
            System.out.println(el);
        }
    }
}






