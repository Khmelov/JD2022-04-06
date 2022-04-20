package by.it.varabyeu.jd01_04;

class InOut {
    private static final String SPLITTER = " ";

    static double[] getArray(String line) {
        String trimLine = line.trim();
        String[] strings = trimLine.split(SPLITTER);
        double[] array = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        return array;
    }
    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-9.4f ", name, i, array[i]);
            if (array.length - 1 == i || (i + 1) % columnCount == 0) {
                System.out.println();
            }
        }
    }
}
