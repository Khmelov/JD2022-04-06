package by.it.kudelko.jd01_03;

public class InOut {


    public static double[] getArray(String line) {
        line = line.trim();
        String[] elemString = line.split(" ");
        int count = elemString.length;
        double[] array = new double[count];
        for (int i = 0; i < count; i++) {
            array[i] = Double.parseDouble(elemString[i]);
        }
        return array;
    }

    public static double[][] getArray2() {
        double[][] matrix = new double[3][3];
        int k = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = k++;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        return matrix;
    }

    public static double[] getArray3() {
        double[] vector = new double[3];
        int k = 1;
        for (int i = 0; i < vector.length; i++) {
            vector[i] = k++;
        }
        return vector;
    }

    public static double[][] getArray4() {
        double[][] matrixLeft = new double[2][2];
        int k = 5;
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixLeft[i].length; j++) {
                matrixLeft[i][j] = k++;
            }
        }
        return matrixLeft;
    }

    public static double[][] getArray5() {
        double[][] matrixRight = new double[2][2];
        int k = 5;
        for (int i = 0; i < matrixRight.length; i++) {
            for (int j = 0; j < matrixRight[i].length; j++) {
                matrixRight[i][j] = k++;
            }
        }
        return matrixRight;
    }

    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String name, int columnCount) {
        int col = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%- 3d]=%-9.4f ", name, i, array[i]);
            col++;
            if ((0 == col % columnCount) || (array.length - 1 == i)) {
                System.out.println();
            }
        }
        System.out.println();
    }

}

