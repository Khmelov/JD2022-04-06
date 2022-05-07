package by.it.eivanova.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Vector extends Var {

    final double[] values;
    public Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }


    public Vector(Vector vector) {
        this(vector.values);
    }

    public Vector(String strVector) {
        strVector = strVector.replace("{", "");
        strVector = strVector.replace("}", "");

        StringTokenizer tokenizer = new StringTokenizer(strVector, ", ");
        int size = tokenizer.countTokens();
        values = new double[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(tokenizer.nextToken());
        }
    }


    // сложение векторов
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + vector.values[i];
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }
    }


     // вычитание
    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - vector.values[i];
            }
            return new Vector(result);
        } else {
            return super.sub(other);
                }
    }

    //умножение

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = new double[this.values.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = this.values[i] * scalar.getValue();
            }
            return new Vector(result);

        } else if (other instanceof Vector otherVector) {
            if (this.values.length==otherVector.values.length){
                double result=0;
                for (int i = 0; i < this.values.length; i++) {
                    result+= this.values[i]*otherVector.values[i];
                }
                return new Scalar(result);
            } else {
                return super.mul(other);
            }
        } else {
            return super.mul(other);
        }




                           }


    //деление
    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
              // result[i] = scalar.getValue() / result[i];
                result[i] = result[i] / scalar.getValue();
            }
            return new Vector(result);


        } else if (other instanceof Vector vector) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
              result[i] = result[i] / vector.values[i];
            }
            return null;
        } else {
            return super.div(other);
        }
    }








    public double[] getValue() {
      return this.values.clone();
    }


    @Override
    public String toString (){
       StringJoiner joiner = new StringJoiner (", ", "{", "}");
        for (double values : values){
            joiner.add(Double.toString(values));
        }
        return joiner.toString();
    }


}
