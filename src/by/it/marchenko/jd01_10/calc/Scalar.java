package by.it.marchenko.jd01_10.calc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
//        if (other instanceof Scalar otherScalar) {
//            return new Scalar(this.value + otherScalar.getValue());
//        } else {
        //Method methodForInvoke = tempResult.getClass().getMethod(methodName, varOperands[i + 1].getClass());
        Object invokeResult = null;
        try {
            Method method = other.getClass().getMethod("add", Var.class);
            System.out.println(method.getName());
            invokeResult = method.invoke(other, this);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {

            e.printStackTrace();
        }
        return (Var)invokeResult;
                //other.add(this);
//        }

    }

    public Var add(Scalar other) {
        System.out.println("Зашли сюда по конструтору");
        return new Scalar(this.value + other.getValue());
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value * otherScalar.getValue());
        } else {
            return other.mul(this);
        }
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
