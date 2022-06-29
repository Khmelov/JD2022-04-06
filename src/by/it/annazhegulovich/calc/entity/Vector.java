package by.it.annazhegulovich.calc.entity;

import by.it.annazhegulovich.calc.exception.CalcException;

import java.util.StringTokenizer;

public class Vector extends Var {

    private final double[] values;


    public Vector(double[] values) {
        this.values = values.clone();
    }

    public Vector(Vector vector){
        this.values=vector.values;
    }

     public Vector(String strVector) {
        strVector = strVector.replace("{", "")
                             .replace("}", "");
         StringTokenizer tokenizer = new StringTokenizer(strVector, ", ");
         int size = tokenizer.countTokens();
         values = new double[size];
         for (int i = 0; i < values.length; i++) {
             values [i] = Double.parseDouble(tokenizer.nextToken());
         }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar scalar){
            //Scalar otherScalar = (Scalar) other;
            double [] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result [i]= result[i]+scalar.getValue();
            }
            return new Vector(result);
        } else if(other instanceof Vector vector){
            //Vector otherVector = (Vector) other;
            if (this.values.length!= vector.values.length){
                throw new CalcException("Incorrect size for %s + %s", this, vector);
            }
            double [] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result [i]= result[i]+vector.values[i];
            }
            return new Vector(result);
        } else{
        return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        //{4, 5, 6} -3 = {1, 2, 3}   {4, 5, 6}-{1, 2, 3}={3, 3, 3}
        if (other instanceof Scalar scalar){
            //Scalar otherScalar = (Scalar) other;
            double [] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result [i]= result[i]-scalar.getValue();
            }
            return new Vector(result);
        }else if (other instanceof Vector vector){
          //  Vector otherVector = (Vector) other;
            double [] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result [i]= result[i]-vector.values[i];
            }
            return new Vector(result);

        } else
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        //{1,2}*3   {1,2}*{3,4}
        if (other instanceof Scalar scalar) {
            //Scalar otherScalar = (Scalar) other;
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector otherVector ) {
            double resultEnd = 0;
            double[] result = values.clone();
            if (result.length == otherVector.values.length){
                for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * otherVector.values[i];
                resultEnd=resultEnd+result[i];
                }
            }
            return new Scalar(resultEnd);
        }
        else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            //Scalar otherScalar = (Scalar) other;
            double[] result =values.clone();
            for (int i = 0; i < result.length; i++) {
               result[i]=result[i]/scalar.getValue();
            }
            return new Vector(result);
        } else
            return super.div(other);
    }



    public double[] getValues() {
        return this.values.clone();
    }


    @Override
    public String toString() {
        String[] strValues = new String[values.length];
        for (int i = 0; i < strValues.length; i++) {
            strValues[i] = String.valueOf(values[i]);
        }
        String arr = String.join( ", ", strValues);
        return  "{"+arr+"}";
    }
}
