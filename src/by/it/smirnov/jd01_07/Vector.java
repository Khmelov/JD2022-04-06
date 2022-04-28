package by.it.smirnov.jd01_07;

class Vector extends Var {

    private final double[] value;

    Vector(double[] value) {
        this.value = value;
    }



    Vector(Vector vector) {
        this.value = vector.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double elem:
             value) {
            sb.append(delimiter).append(elem);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
