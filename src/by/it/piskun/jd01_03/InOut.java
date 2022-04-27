package by.it.piskun.jd01_03;

import java.util.Locale;

public class InOut {

    public static final String SPLITTER = " ";

    public static double[] getArray(String line){
        String trimLine = line.trim();
        String[] strings = trimLine.split(SPLITTER);
        double[] array = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i]=Double.parseDouble(strings[i]);

            
        }
        return array;
    }

    public static void printArray(double[] array) {
        for (double element : array){
            System.out.print(element+" ");
        }
        System.out.println();
    }
    static void printArray(double[ ] array, String name, int columnCount){
        for (int index = 0; index < array.length; index++) {
            System.out.printf(Locale.ENGLISH,"%s[% -3d]=%-9.4f",name,index,array[index]);
            if(array.length-1==index || (index+1)%columnCount==0){
                System.out.println();
            }
        }
    }
}
