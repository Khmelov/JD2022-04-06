package by.it.marchenko.jd01_10.calc;

import java.util.Arrays;

public class Vector extends Var {
    final String INCORRECT_INPUT_MESSAGE = "Incorrect vector input";

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
            System.out.println(INCORRECT_INPUT_MESSAGE);
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
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[] tempVector = getVectorValues();
            for (int i = 0; i < tempVector.length; i++) {
                tempVector[i] += otherScalar.getValue();
            }
            return new Vector(tempVector);
        } else if (other instanceof Vector otherVector) {
            double[] tempVector = getVectorValues();

            for (int i = 0; i < tempVector.length; i++) {
                tempVector[i] += otherVector.vectorValues[i];
            }
            return new Vector(tempVector);
        } else {
            return super.add(other);
        }
    }

    public Var add(Scalar other) {
        double[] tempVector = getVectorValues();
        for (int i = 0; i < tempVector.length; i++) {
            tempVector[i] += other.getValue();
        }
        System.out.println("Зашли по конуструктору вектор + скаляр");
        return new Vector(tempVector);

    }

    public Var add(Vector other) {
        double[] tempVector = getVectorValues();
        for (int i = 0; i < tempVector.length; i++) {
            tempVector[i] += other.vectorValues[i];
        }
        System.out.println("Зашли по конуструктору вектор+вектор");
        return new Vector(tempVector);
    }



    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[] tempVector = getVectorValues();
            for (int i = 0; i < tempVector.length; i++) {
                tempVector[i] -= otherScalar.getValue();
            }
            return new Vector(tempVector);
        } else if (other instanceof Vector otherVector) {
            double[] tempVector = getVectorValues();

            for (int i = 0; i < tempVector.length; i++) {
                tempVector[i] -= otherVector.vectorValues[i];
            }
            return new Vector(tempVector);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[] tempVector = getVectorValues();
            for (int i = 0; i < tempVector.length; i++) {
                tempVector[i] *= otherScalar.getValue();
            }
            return new Vector(tempVector);
        } else if (other instanceof Vector otherVector) {
            double result = 0;
            for (int i = 0; i < this.vectorValues.length; i++) {
                result += this.vectorValues[i] * otherVector.vectorValues[i];
            }
            return new Scalar(result);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[] tempVector = getVectorValues();
            for (int i = 0; i < tempVector.length; i++) {
                tempVector[i] /= otherScalar.getValue();
            }
            return new Vector(tempVector);
        } else {
            return super.div(other);
        }
    }
}
