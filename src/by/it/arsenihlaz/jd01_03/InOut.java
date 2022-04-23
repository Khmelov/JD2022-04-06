package by.it.arsenihlaz.jd01_03;

class InOut {

    static double[] getArray(String line) {
        String trimLine = line.trim();
        String[] strings = trimLine.split(" ");
        double[] array = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        return array;
    }
   static void printArray(double[ ] array){
       for (int i = 0; i < array.length; i++) {
           System.out.print(array[i] + " ");
       }
       System.out.println();
   }

    static void printArray(double[ ] array, String name, int columnCount){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%3s %-2d. = [%-4.2f] ", name, i, array[i]);
            if ((0 == ((i+1) % columnCount)) || array.length - 1 == i) {
                System.out.println();
            }
        }
    }
}
