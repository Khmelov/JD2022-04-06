package by.it.machuga.jd01_09;

import static by.it.machuga.jd01_09.ConstantStorage.*;

abstract class Var implements Operation {
    public static Var createVar(String operand) {
        operand = operand.trim().replace(SPACE, EMPTY_STRING);
        if (operand.matches(SCALAR_REGEX)) {
            return new Scalar(operand);
        }
        if (operand.matches(VECTOR_REGEX)) {
            return new Vector(operand);
        }
        if (operand.matches(MATRIX_REGEX)) {
            return new Matrix(operand);
        }
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Cannot add " + this + " and " + other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Cannot subtract " + this + " and " + other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Cannot multiply " + this + " and " + other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Cannot divide " + this + " by " + other);
        return null;
    }

    @Override
    public String toString() {
        return "unknown variable (abstract stub)";
    }
}
