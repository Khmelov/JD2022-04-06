package by.it.arsenihlaz.jd01_07;
/*переопределяем метод стринг для массивов чтобы менял скобочки
и поэтому в конструкторе для стринга нужно его преобразовать в массив...
если я правильно понял
 */
import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = value.clone();
    }

    public Vector(Vector vector) {
        this.value = vector.value.clone();
    }

    public Vector(String strVector) {
        String strVectornew = strVector.replaceAll("[{}]", "");
        String[] arrayStrVector = strVectornew.split(",");
        this.value = new double[arrayStrVector.length].clone();
        for (int i = 0; i < arrayStrVector.length; i++) {
            this.value[i] = Double.parseDouble(arrayStrVector[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringArrays = new StringBuilder(Arrays.toString(value));
        stringArrays = stringArrays.replace(0, 1, "{");
        stringArrays = stringArrays.replace(stringArrays.length() - 1, stringArrays.length(), "}");
        return String.valueOf(stringArrays);
//        StringBuilder stringArrays = new StringBuilder("{");
//        String delimeter = "";
//        for (double elements : value) {
//            stringArrays.append(delimeter).append(elements);
//            delimeter = ", ";
//        }
//        stringArrays.append("}");
//        return stringArrays.toString();
    }
}
