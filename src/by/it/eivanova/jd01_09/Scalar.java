package by.it.eivanova.jd01_09;

class Scalar extends Var {

    private final double value;
    public Scalar(double value) {
        this.value = value;
    }

   public Scalar (Scalar scalar){
        this.value = scalar.value;
    }

    public Scalar (String stringValue){
        this.value = Double.parseDouble(stringValue);
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }





    //Сложение
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar){
            return new Scalar(this.value + otherScalar.value);
          //double result = this.value + otherScalar.value;
       //   return new Scalar(result);
        }
        else {
            return other.add(this);
        }
    }


    //Вычитание
    @Override
    public Var sub(Var other) {
        //1-{1,2,3} == ({1,2,3}-1)* -1
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value - otherScalar.value);
        } else {
            return other.add(this).mul(new Scalar(-1));
        }
    }

    //Умножение
   @Override
   public Var mul(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value * otherScalar.value);
        } else {
            return other.add(this);
        }
    }

    //Деление
   @Override
       public Var div(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value / otherScalar.value);
        } else {
            return super.div(other);
        }
    }
}



