package by.it.marchenko.calc;

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
        return other.add(this);
    }

    public Var add(Scalar other) {
        return new Scalar(this.value + other.getValue());
    }

    public Var add(Vector other) {
        return other.add(this);
    }

    public Var add(Matrix other) {
        return other.add(this);//new Scalar(this.value + other.getValue());
    }

    @Override
    public Var mul(Var other) {
        return other.mul(this);
    }

    public Var mul(Scalar other) {
        return new Scalar(this.value * other.getValue());
    }

    @Override
    public Var mul(Vector other) {
        return other.mul(this);
    }

    @Override
    public Var mul(Matrix other) {
        return other.mul(this);
    }

    @Override
    public Var sub(Var other) {
        final Scalar MINUS_ONE = new Scalar(-1d);
        return other.mul(MINUS_ONE).add(this);
    }

    @Override
    public Var div(Var other) {
        System.out.println("Зашли сюда как Scalar/Var");
        return other.div(this);
        /*
        //
        Object tempResult = this;
        try {
            Method method = this.getClass().getMethod(DIV_STRING_OPERATOR, other.getClass());
            tempResult = method.invoke(this, other);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return (Var) tempResult;

         */
    }

    public Var div(Scalar other) {
        System.out.println("Зашли сюда как Scalar/Scalar");
        return new Scalar(other.getValue() / this.value);
    }

    public Var div(Vector other) {
        //System.out.println("Зашли сюда как Scalar/Vector");
        //return super.div((Var) other);
        double[] tempVector = other.getVectorValues();
        for (int i = 0; i < tempVector.length; i++) {
            tempVector[i] /= this.getValue();
        }
        return new Vector(tempVector);

    }

    public Var div(Matrix other) {
        //System.out.println("Зашли сюда как Scalar/matrix");
        //return super.div((Var) other);
        double[][] tempMatrix = other.getMatrixValue();
        for (int i = 0; i < tempMatrix.length; i++) {
            for (int j = 0; j < tempMatrix[i].length; j++) {
                tempMatrix[i][j] /= this.getValue();
            }
        }
        return new Matrix(tempMatrix);
    }
}
