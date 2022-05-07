package by.it.machuga.jd01_09;

class Scalar extends Var {
    private final double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            return Summator.addScalarToScalar(this, scalar);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            return Substractor.subScalarFromScalar(this, scalar);
        } else {
            return new Scalar(-1).mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar) {
            return Multiplicator.mulScalarByScalar(this, scalar);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar && scalar.value != 0) {
            return Divider.divScalarByScalar(this, scalar);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
