package by.it.kadulin.jd01_08;



class Scalar extends Var {

    public double getValue() {
        return value;
    }

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar value) {
        this.value = value.value;
    }

    public Scalar(String value) {
        this.value = Double.parseDouble(value);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value + otherScalar.value);
        }
        else {
            return other.add(this);
        }
    }

//    public Var add(Scalar other) {
//        return new Scalar(this.value + other.value);
//    }
//
//    public Var add(Vector other) {
//        return other.add(this);
//    }
//
//    public Var add(Matrix other) {
//        return other.add(this);
//    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value - otherScalar.value);
        }
        else {
            return other.add(this).mul(new Scalar(-1));
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value * otherScalar.value);
        }
        else {
            return other.add(this);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value / otherScalar.value);
        }
        else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
