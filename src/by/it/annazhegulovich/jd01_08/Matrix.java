package by.it.annazhegulovich.jd01_08;

class Matrix extends Var {

    private final double[][] value2;

    public Matrix(double[][] value) {
        value2 = new double[value.length][value.length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                value2 [i][j] = value [i][j];
            }
        }
    }
    public Matrix(Matrix matrix){
        this.value2= matrix.value2;
    }
    public Matrix(String strMatrix){

        String [] res= strMatrix.split("},");
        this.value2 = new double[res.length][];
        for (int i = 0; i <res.length ; i++) {
            String strRes= res[i];
            strRes = strRes.replace("{","")
                            .replace("}","")
                            .replace(" ","");
            String [] resi= strRes.split(",");
            value2[i]=new  double[resi.length];
            for (int j = 0; j < value2[i].length; j++) {
                this.value2[i][j]= Double.parseDouble(resi[j]);
            }
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] result = value2.clone();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = result[i][j] * otherScalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[][] result = value2.clone();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = result[i][j] * otherVector.getValues()[j];
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] result = value2.clone();
            for (int i = 0; i < result.length; i++) {
                double resultIJ = 0;
                for (int j = 0; j < result[0].length; j++) {
                    for (int k = 0; k < result[0].length; k++) {
                        resultIJ = result[i][j] * otherMatrix.value2[j][i];
                        resultIJ += resultIJ;
                    }
                    result[i][j] = resultIJ;
                }
                return new Matrix(result);
            }
        }

        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            /*Scalar otherScalar = (Scalar) other;
            double[][] result = value2.clone();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j]= result[i][j]/otherScalar.getValue();

                }
            } return new Matrix(result);
            } else*/
            return other.add(this);
        } else
        return super.div(other);
    }

    @Override
    public String toString() {
        String strMatrix = new String();
        for (int i = 0; i < value2.length; i++) {
            strMatrix += "{";
            for (int j = 0; j < value2.length; j++) {
                strMatrix += Double.toString(value2[i][j]);
                if (j != value2.length - 1) {
                    strMatrix += ", ";
                }
            }
            strMatrix = strMatrix + "}";
            if (i != value2.length - 1) {
                strMatrix += ", ";
            }
        }
        return  "{"+strMatrix.toString()+"}";
    }
}
