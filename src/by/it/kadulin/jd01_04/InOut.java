package by.it.kadulin.jd01_04;

class InOut {


    static double[] getArray(String line) {
        String trimLine = line.trim();
        String[] stringArray = trimLine.split(" ");
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        return doubleArray;
    }

    static void printArray(double[] array) {
        for (double x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-9.4f", name, i, array[i]);
            if (columnCount == i + 1 || (i + 1) % columnCount == 0) {
                System.out.println();
            }
        }
    }


}
