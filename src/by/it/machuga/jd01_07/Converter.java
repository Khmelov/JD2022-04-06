package by.it.machuga.jd01_07;

public class Converter {
    static double[] convertStringToDoubleArray(String strVector) {
        String formattedString = strVector.replaceAll("[{}]", "");
        String[] arrayString = formattedString.trim().split(",\\s*");
        double[] arrayDouble = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayDouble[i] = Double.parseDouble(arrayString[i]);
        }
        return arrayDouble;
    }

    static String convertDoubleArrayToString(double[] array) {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (i != array.length - 1) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("}");
            }
        }
        return stringBuilder.toString();
    }
}
