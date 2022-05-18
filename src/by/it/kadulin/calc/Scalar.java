package by.it.kadulin.calc;


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

//    public Var sub(Scalar other) {
//        return new Scalar(this.value - other.value);
//    }
//
//    public Var sub(Vector other) {
//        return other.add(this);
//    }
//
//    public Var sub(Matrix other) {
//        return other.add(this);
//    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value * otherScalar.value);
        }
        else {
            return other.add(this);
        }
    }

//    public Var mul(Scalar other) {
//        return new Scalar(this.value * other.value);
//    }
//
//    public Var mul(Vector other) {
//        return other.add(this);
//    }
//
//    public Var mul(Matrix other) {
//        return other.add(this);
//    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value / otherScalar.value);
        }
        else {
            return super.div(other);
        }
    }

//    public Var div(Scalar other) {
//        return new Scalar(this.value / other.value);
//    }
//
//    public Var div(Vector other) {
//        return super.div(other);
//    }
//
//    public Var div(Matrix other) {
//        return super.div(other);
//    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
