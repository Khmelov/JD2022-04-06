package by.it.selvanovich.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-9.5f ", name, i, array[i]);
            if (array.length - 1 == 1 || (i + 1) % columnCount == 0) {
                System.out.println();
            }
        }
    }


    private static void step1() {
        double min = 5.33;
        double max = 9;
        int randomIndex = (int) (Math.random() * ((40 - 20) + 1)) + 20;
        double[] arrayA = new double[randomIndex];
        double step = (max - min)/(randomIndex - 1);
        int arrayLenght = 0;
        for (int i = 0; i < arrayA.length; i++) {
            double x = min + step * i;
            double z = Math.cbrt(Math.pow(x, 2) + 4.5);
            arrayA[i] = z;
            if (z > 3.5) {
                arrayLenght++;
            }
        }
        printArray(arrayA, "A", 5);
        System.out.println();
        double[] arrayB = new double[arrayLenght];
        int indexB = 0;
        for (double element : arrayA){
            if (element > 3.5) {
                arrayB[indexB] = element;
                indexB++;
            }
        }
        printArray(arrayB, "B", 5);
    }
}
