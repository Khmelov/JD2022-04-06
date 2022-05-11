package by.it.marchenko.jd01_10.calc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

//import static by.it.marchenko.jd01_09.MessageConst.SUB_OPERATOR;
import static by.it.marchenko.jd01_10.calc.MessageConst.*;

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
        System.out.println("Зашли сюда как Vector+Var");
        Object tempResult = this;
        try {
            Method method = this.getClass().getMethod(ADD_STRING_OPERATOR, other.getClass());
            tempResult = method.invoke(this, other);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return (Var) tempResult;
    }

    public Var add(Scalar other) {
        System.out.println("Зашли сюда как Vector+Scalar");
        double[] tempVector = getVectorValues();
        for (int i = 0; i < tempVector.length; i++) {
            tempVector[i] += other.getValue();
        }
        return new Vector(tempVector);

    }

    public Var add(Vector other) {
        System.out.println("Зашли сюда как Vector+Vector");
        double[] tempVector = getVectorValues();
        for (int i = 0; i < tempVector.length; i++) {
            tempVector[i] += other.vectorValues[i];
        }
        return new Vector(tempVector);
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Зашли сюда как Vector*Var");
        Object tempResult = this;
        try {
            Method method = this.getClass().getMethod(MUL_STRING_OPERATOR, other.getClass());
            tempResult = method.invoke(this, other);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return (Var) tempResult;
    }

    public Var mul(Scalar other) {
        double[] tempVector = getVectorValues();
        System.out.println("Зашли сюда как Vector*Scalar");
        for (int i = 0; i < tempVector.length; i++) {
            tempVector[i] *= other.getValue();
        }
        return new Vector(tempVector);
    }

    public Var mul(Vector other) {
        System.out.println("Зашли сюда как Vector*Vector");
        double result = 0;
        for (int i = 0; i < this.vectorValues.length; i++) {
            result += this.vectorValues[i] * other.vectorValues[i];
        }
        return new Scalar(result);
    }


    @Override
    public Var sub(Var other) {
        Object tempResult = this;
        try {
            Method method = tempResult.getClass().
                    getMethod(SUB_OPERATOR, other.getClass());
            tempResult = method.invoke(tempResult, other);
        } catch (NoSuchMethodException e) {
            try {
                Method method = other.getClass().
                        getMethod(SUB_OPERATOR, tempResult.getClass());
                tempResult = method.invoke(other, tempResult);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


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
