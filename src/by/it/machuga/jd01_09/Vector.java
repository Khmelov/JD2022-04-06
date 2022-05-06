package by.it.machuga.jd01_09;

import static by.it.machuga.jd01_09.Converter.convertDoubleArrayToString;
import static by.it.machuga.jd01_09.Converter.convertStringToDoubleArray;

class Vector extends Var {
    private final double[] value;

    Vector(double[] value) {
        this.value = value.clone();
    }

    Vector(Vector vector) {
        this.value = vector.value.clone();
    }

    Vector(String strVector) {
        this.value = convertStringToDoubleArray(strVector);
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Vector vector && this.value.length == vector.value.length) {
            return Summator.addVectorToVector(this, vector);
        } else if (other instanceof Scalar scalar) {
            return Summator.addScalarToVector(this, scalar);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector vector && this.value.length == vector.value.length) {
            return Substractor.subVectorFromVector(this, vector);
        } else if (other instanceof Scalar scalar) {
            return Substractor.subScalarFromVector(this, scalar);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector vector && this.value.length == vector.value.length) {
            return Multiplicator.mulVectorByVector(this, vector);
        } else if (other instanceof Scalar scalar) {
            return Multiplicator.mulVectorByScalar(this, scalar);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar && scalar.getValue() != 0) {
            return Divider.divVectorByScalar(this, scalar);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return convertDoubleArrayToString(value);
    }
}
