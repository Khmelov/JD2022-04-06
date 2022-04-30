package by.it.ragach.jd01_07;

 class Scalar extends Var {

     private final double value;

     Scalar(double value) {
         this.value = value;
     }

     Scalar (Scalar scalar) {
         this.value = scalar.value;
     }

     Scalar (String stringValue){
         value = Double.parseDouble(stringValue);

     }

     public double getValue() {
         return value;
     }

     @Override
     public String toString() {
         return Double.toString(value);
     }
 }
