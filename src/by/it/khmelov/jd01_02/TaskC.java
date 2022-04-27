package by.it.khmelov.jd01_02;

public class TaskC {

    static int[][] step3(int[][] array) {
        //findMax
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        //delArrays
        boolean[] delRows = new boolean[array.length];
        boolean[] delCols = new boolean[array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max == array[i][j]) {
                    delRows[i] = true;
                    delCols[j] = true;
                }
            }
        }

        //getSize;
        int rows = 0;
        for (boolean delRow : delRows) {
            if (!delRow) {
                rows++;
            }
        }
        int cols = 0;
        for (boolean delCol : delCols) {
            if (!delCol) {
                cols++;
            }
        }

        //fillResult
        int[][] result = new int[rows][cols];
        for (int i = 0, iResult = 0; i < array.length; i++) {
            if (!delRows[i]) {
                for (int j = 0, jResult = 0; j < array[i].length; j++) {
                    if (!delCols[j]){
                        result[iResult][jResult]=array[i][j];
                        jResult++;
                    }
                }
                iResult++;
            }
        }

        return result;
    }
}
