package by.it.machuga.jd01_09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.machuga.jd01_09.ConstantStorage.VECTOR_REGEX;

public class Converter {

    static double[] convertStringToDoubleArray(String strVector) {
        String formattedString = strVector.replaceAll(ConstantStorage.CURLY_BRACES, ConstantStorage.EMPTY_STRING);
        String[] arrayString = formattedString.trim().split(ConstantStorage.COMMA_SPACE);
        double[] arrayDouble = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayDouble[i] = Double.parseDouble(arrayString[i]);
        }
        return arrayDouble;
    }

    static String convertDoubleArrayToString(double[] array) {
        StringBuilder stringBuilder = new StringBuilder(ConstantStorage.LEFT_CURLY_BRACE);
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (i != array.length - 1) {
                stringBuilder.append(ConstantStorage.COMMA_SPACE_APPENDER);
            } else {
                stringBuilder.append(ConstantStorage.RIGHT_CURLY_BRACE);
            }
        }
        return stringBuilder.toString();
    }

    static String convertDoubleMultiDimensionArrayToString(double[][] array) {
        StringBuilder stringBuilder = new StringBuilder(ConstantStorage.LEFT_CURLY_BRACE);
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(convertDoubleArrayToString(array[i]));
            if (i != array.length - 1) {
                stringBuilder.append(ConstantStorage.COMMA_SPACE_APPENDER);
            } else {
                stringBuilder.append(ConstantStorage.RIGHT_CURLY_BRACE);
            }
        }
        return stringBuilder.toString();
    }

    static double[][] convertStringToDoubleMultiDimensionArray(String strMatrix) {
        Pattern pattern = Pattern.compile(VECTOR_REGEX);
        Matcher matcher = pattern.matcher(strMatrix);
        double[][] arrayMultiDimensionArray = new double[0][];
        while (matcher.find()) {
            String stringArray = matcher.group();
            double[] element = convertStringToDoubleArray(stringArray);
            double[][] temp = Arrays.copyOf(arrayMultiDimensionArray, arrayMultiDimensionArray.length + 1);
            temp[temp.length - 1] = element;
            arrayMultiDimensionArray = temp;
        }
        return arrayMultiDimensionArray;
    }
}
