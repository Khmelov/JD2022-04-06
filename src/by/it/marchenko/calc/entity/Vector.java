package by.it.marchenko.calc.entity;

import by.it.marchenko.calc.constant.MessageConst;

import java.util.Arrays;

public class Vector extends Var {

    private final String OPEN_CURVE_BRACKET = "{";
    private final String CLOSE_CURVE_BRACKET = "}";
    final String OPEN_SQUARE_BRACKET = "\\[";
    final String CLOSE_SQUARE_BRACKET = "]";
    final String VECTOR_SEPARATOR = ", *";

    private final double[] vectorValues;

    public Vector(double[] value) {
        this.vectorValues = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.vectorValues = Arrays.copyOf(vector.vectorValues, vector.vectorValues.length);
    }

    public Vector(String stringVector) {
        if (stringVector.indexOf(OPEN_CURVE_BRACKET) == 0 &&
                stringVector.indexOf(CLOSE_CURVE_BRACKET) == stringVector.length() - 1) {
            stringVector = stringVector.substring(1, stringVector.length() - 1);
            String[] stringValuesArray = stringVector.split(VECTOR_SEPARATOR);
            double[] tempDoubleArray = new double[stringValuesArray.length];
            for (int i = 0; i < stringValuesArray.length; i++) {
                tempDoubleArray[i] = Double.parseDouble(stringValuesArray[i]);
            }
            this.vectorValues = Arrays.copyOf(tempDoubleArray, tempDoubleArray.length);
        } else {
            System.out.println(MessageConst.INCORRECT_VECTOR_INPUT_MESSAGE);
            this.vectorValues = null;
        }
    }

    public double[] getVectorValues() {
        return vectorValues.clone();
    }

    @Override
    public String toString() {
        String outputString = Arrays.toString(vectorValues);
        outputString = outputString.replaceAll(OPEN_SQUARE_BRACKET, OPEN_CURVE_BRACKET);
        outputString = outputString.replaceAll(CLOSE_SQUARE_BRACKET, CLOSE_CURVE_BRACKET);
        return outputString;
    }

    @Override
    public Var foundVarType(Var operand, String operator) {
       return operand.foundVarType(this,operator);
    }

    public Var add(Scalar other) {
        //System.out.println("Vector Vector+Scalar");
        double[] tempVector = getVectorValues();
        for (int i = 0; i < tempVector.length; i++) {
            tempVector[i] += other.getValue();
        }
        return new Vector(tempVector);

    }

    public Var add(Vector other) {
        //System.out.println("Vector Vector+Vector");
        double[] tempVector = getVectorValues();
        for (int i = 0; i < tempVector.length; i++) {
            tempVector[i] += other.vectorValues[i];
        }
        return new Vector(tempVector);
    }

    public Var add(Matrix other) {
        //System.out.println("Vector Vector+Matrix");
        return super.add((Var)other);
    }



    @Override
    public Var mul(Var other) {
        return other.mul(this);
    }

    public Var mul(Scalar other) {
        double[] tempVector = getVectorValues();
        for (int i = 0; i < tempVector.length; i++) {
            tempVector[i] *= other.getValue();
        }
        return new Vector(tempVector);
    }

    public Var mul(Vector other) {
        double result = 0;
        for (int i = 0; i < this.vectorValues.length; i++) {
            result += this.vectorValues[i] * other.vectorValues[i];
        }
        return new Scalar(result);
    }

    @Override
    public Var mul(Matrix other) {
        double[][] tempMatrix = other.getMatrixValue();
        return new Vector(Matrix.calculateMatrixMultiply(tempMatrix, this.getVectorValues()));
    }


    @Override
    public Var sub(Var other) {
        final Scalar MINUS_ONE = new Scalar(-1d);
        return other.mul(MINUS_ONE).add(this);
    }


    @Override
    public Var div(Var other) {
        //System.out.println("Зашли сюда как Vector/Var");
        return other.div(this);
       /*
        Object tempResult = this;
        try {
            Method method = this.getClass().getMethod(DIV_STRING_OPERATOR, other.getClass());
            tempResult = method.invoke(this, other);
        } catch (NoSuchMethodException e) {
            return super.div(other);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return (Var) tempResult;

        */
    }

    public Var div(Scalar other) {
        //System.out.println("Зашли сюда как Vector/Scalar");
        double[] tempVector = getVectorValues();
        for (int i = 0; i < tempVector.length; i++) {
            tempVector[i] /= other.getValue();
        }
        return new Vector(tempVector);
    }

    @Override
    public Var div(Vector other) {
        return super.div((Var) other);
    }

    @Override
    public Var div(Matrix other) {
        return super.div((Var) other);
    }
}


