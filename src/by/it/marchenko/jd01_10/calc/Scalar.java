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

    public Var sub(Scalar other) {
        System.out.println("Зашли сюда по конструтору");
        return new Scalar(this.value - other.getValue());
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value - otherScalar.getValue());
        } else {
            return other.mul(new Scalar(-1)).add(this);
        }
    }


    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value / otherScalar.getValue());
        } else {
            return super.div(other);
        }
    }

}
