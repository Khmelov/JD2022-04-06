package by.it.marchenko.jd01_10.calc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static by.it.marchenko.jd01_10.calc.MessageConst.*;

public class Scalar extends Var {
    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar value) {
        this.value = value.value;
    }

    public Scalar(String stringScalar) {
        this.value = Double.parseDouble(stringScalar);
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    //@Override
    //public Var operation(String operator, Var operand) {
    //    return null;
   // }

    @Override
    public Var add(Var other) {
        System.out.println("Зашли сюда как Scalar+Var");
        Object tempResult = this;
        try {
            Method method = other.getClass().getMethod(ADD_STRING_OPERATOR, this.getClass());
            tempResult = method.invoke(other, this);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return (Var) tempResult;
    }

    public Var add(Scalar other) {
        System.out.println("Зашли сюда как Scalar+Scalar");
        return new Scalar(this.value + other.getValue());
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Зашли сюда как Scalar*Var");
        Object tempResult = this;
        try {
            Method method = other.getClass().getMethod(MUL_STRING_OPERATOR, this.getClass());
            tempResult = method.invoke(other, this);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return (Var) tempResult;
    }

    public Var mul(Scalar other) {
        System.out.println("Зашли сюда как Scalar*Scalar");
        return new Scalar(this.value * other.getValue());
    }

    @Override
    public Var sub(Var other) {
        final Scalar MINUS_ONE = new Scalar(-1d);
        System.out.println("Зашли сюда как Scalar-Var");
        Object tempResult = this;
        try {
            Method methodMul = other.getClass().
                    getMethod(MUL_STRING_OPERATOR, MINUS_ONE.getClass());
            tempResult = methodMul.invoke(other, MINUS_ONE);
            Method methodAdd = other.getClass().getMethod(ADD_STRING_OPERATOR, this.getClass());
            tempResult = methodAdd.invoke(tempResult, this);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return (Var) tempResult;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Зашли сюда как Scalar/Var");
        Object tempResult = this;
        try {
            Method method = this.getClass().getMethod(DIV_STRING_OPERATOR, other.getClass());
            tempResult = method.invoke(this, other);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return (Var) tempResult;
    }

    public Var div(Scalar other) {
        System.out.println("Зашли сюда как Scalar/Scalar");
        return new Scalar(this.value / other.getValue());
    }


}
