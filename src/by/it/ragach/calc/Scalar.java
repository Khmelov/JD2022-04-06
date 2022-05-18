package by.it.ragach.calc;

class Scalar extends Var {

     private final double value;

     Scalar(double value) {
         this.value = value;
     }

     Scalar (Scalar scalar) {
         this.value = scalar.value;
     }

     Scalar (String stringValue){
         value = Double.parseDouble(stringValue);

     }


    @Override
    public Var add(Var other) {
         //1+2
        if (other instanceof Scalar otherScalar){
            return  new Scalar(this.value+ otherScalar.value);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar){
            return  new Scalar(this.value- otherScalar.value);
        } else {
            return other.add(this.mul(new Scalar(-1)));
        }

    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar){
            return  new Scalar(this.value* otherScalar.value);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar){
            return  new Scalar(this.value/ otherScalar.value);
        } else {
            return super.div(other);
        }

    }

    public double getValue() {
         return value;
     }

     @Override
     public String toString() {
         return Double.toString(value);
     }
 }
