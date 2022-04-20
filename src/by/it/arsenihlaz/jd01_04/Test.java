package by.it.arsenihlaz.jd01_04;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        double[] array = {5, 2, 1, 3, 6, 7, 8, 0};
        getPart(array, array.length / 2, array.length - array.length / 2);
        merge(new double[]{}, new double[]{});
    }

    private static double[] getPart(double[] array, int left, int right) {
        if (array == null) {
            return null;
        }
        if (array.length < 2) {
            return array;
        }
        double[] arrayLeft = new double[left];
        System.arraycopy(array, 0, arrayLeft, 0, arrayLeft.length);
        double[] arrayRight = new double[right];
        System.arraycopy(array, arrayLeft.length, arrayRight, 0, arrayRight.length);
        left = arrayLeft.length / 2;
        right = arrayLeft.length - arrayLeft.length / 2;
        arrayLeft = getPart(arrayLeft, left, right);
        arrayRight = getPart(arrayRight, left, right);
        return merge(arrayLeft, arrayRight);
    }

    private static double[] merge(double[] arrayLeft, double[] arrayRight) {
        double[] arraySort = new double[arrayLeft.length + arrayRight.length];
        System.arraycopy(arrayLeft, 0, arraySort, 0, arrayLeft.length);
        System.arraycopy(arrayRight, arrayLeft.length, arraySort, 0, arrayRight.length);
        int positionLeft = 0;
        int positionRight = 0;
        for (int i = 0; i < arrayLeft.length; i++) {
            if (arrayLeft[i - positionLeft] <= arrayRight[i - positionRight]) {
                arraySort[i] = arrayLeft[i];
                positionLeft++;
            } else if (positionLeft == arrayLeft.length) {
                arraySort[i] = arrayRight[i];
                positionRight++;
            } else if (positionRight == arrayRight.length) {
                arraySort[i] = arrayLeft[i];
                positionLeft++;
            } else
                arraySort[i] = arrayRight[i];
            positionRight++;

        }
        for (int i = 0; i < arraySort.length; i++) {
            System.out.printf("%1s[% -3d]=%-1.3f ", "V", i, arraySort[i]);
        }
        return arraySort;
    }
}
