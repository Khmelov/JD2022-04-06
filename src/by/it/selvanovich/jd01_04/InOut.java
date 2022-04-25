package by.it.selvanovich.jd01_04;

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

    public static double[ ][ ] generateMatrix(int n) {
        double[][] array = new double[n][n];
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                int random = (int) (Math.random() * ((n - (-n)) + 1)) + (-n);
                array[x][y] = random;
            }
        }
        return array;
    }

    public static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element+" ");
        }
        System.out.println();
    }
    static void printArray(double[] array, String name, int columnCount){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-9.4f ", name, i, array[i]);
            if (array.length-1==1 || (i+1)%columnCount==0){
                System.out.println();
            }
        }
    }
    public static void printMatrix(double[][] array){
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                System.out.print(array[x][y] + " ");
            }
            System.out.println();
        }
    }
}
