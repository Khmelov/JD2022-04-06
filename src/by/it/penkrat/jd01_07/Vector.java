package by.it.penkrat.jd01_07;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value.clone();
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        String str = strVector.replaceAll("[{}\\s]+", "");
        String[] newStr = str.split(",");
        double[] value1 = new double[newStr.length];
        for (int i = 0; i < value1.length; i++) {
            value1[i] = Double.parseDouble(newStr[i]);
            this.value = value1;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
