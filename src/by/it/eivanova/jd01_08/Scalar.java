package by.it.eivanova.jd01_08;

class Scalar extends Var {

    private final double value;
    public Scalar(double value) {
        this.value = value;
    }

    public Scalar (Scalar scalar){
        this.value = scalar.value;
    }

    public Scalar (String stringValue){
        value = Double.parseDouble(stringValue);
    }




    //Сложение
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar){
          double result = this.value + otherScalar.value;
          return new Scalar(result);
        }
        else {
            return other.add(this);
        }
    }

    //Вычитание
    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar){
            double result = this.value - otherScalar.value;
            return new Scalar(result);
        }
        else {
            return other.add(this).mul(new Scalar(-1));
        }
    }




    //Умножение
    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar){
            double result = this.value * otherScalar.value;
            return new Scalar(result);
        }
        else {
            return other.add(this);
        }
    }



    //Деление
    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar){
            double result = this.value / otherScalar.value;
            return new Scalar(result);
        }
        else {
            return other.div(other);
        }
    }










    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
