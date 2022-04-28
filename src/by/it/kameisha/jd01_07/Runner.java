package by.it.kameisha.jd01_07;

public class Runner {
    public static void main(String[] args) {
        String strVector = "{1.0, 2.0, 4.0}";
        strVector = strVector.replace("{","");
        strVector = strVector.replace("}","");
        String[] strings = strVector.split(",");
        double[] value = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            value[i] = Double.parseDouble(strings[i]);
        }
        System.out.println(value[2]);
    }
}
