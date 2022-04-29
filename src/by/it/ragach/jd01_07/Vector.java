package by.it.ragach.jd01_07;

import java.util.Arrays;

 class Vector extends Var {

    private final double [] value;

    Vector(double[] value) {
        this.value = value.clone();
    }

     Vector(Vector vector){
        this.value = vector.value;
    }


    Vector (String strVector){
        this.value= changeStringToDoubleArray(strVector);


}

     private double[] changeStringToDoubleArray(String strVector) {
        String change = strVector.replaceAll("[{}]","");
        String [] array  = change.trim().split(",");
        double [] array2 = new double[array.length];
         for (int i = 0; i < array.length; i++) {
             array2 [i] = Double.parseDouble(array[i]);
         }
         return array2;
     }


     @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        String delimiter ="";
        for (double element : value) {
            str.append(delimiter).append(element);
            delimiter=", ";
        }
        str.append("}");
        return  str.toString();

    }

 }
