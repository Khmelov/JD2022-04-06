package by.it.avramchuk.jd01_04;

public class InOut {

    public static final String SPACE = " ";

    public static double[] getArray(String line) {
        String trimLine = line.trim();
        String[] strings = trimLine.split(SPACE);
        double[] array = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        return array;
    }

    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void printArray(double[] array, String name, int columnCount){
        for (int index = 0; index < array.length; index++) {
            System.out.printf("%s[% -3d]=%-9.4f", name, index, array[index]);
            if (index == array.length-1 || ((index+1)%columnCount == 0) ){
                System.out.println();
            }
        }
    }

}
