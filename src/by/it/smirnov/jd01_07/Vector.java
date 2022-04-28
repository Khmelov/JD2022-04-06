package by.it.smirnov.jd01_07;

class Vector extends Var {

    private final double[] values;

    Vector(double[] values) {
        this.values = values.clone();
    }

    Vector(String strVector) {
        //strVector.replace('{', "");
        String buffer = strVector.replaceAll("\\{", "");
        buffer = buffer.replaceAll("}", "");
        buffer = buffer.replaceAll("\\s", "");
                String[] fromString = buffer.split(",");
        double[] toDouble = new double[fromString.length];
        for (int i = 0; i < toDouble.length; i++) {
            toDouble[i] = Double.parseDouble(fromString[i]);
        }
        this.values = toDouble;
    }

    Vector(Vector vector) {
        this.values = vector.values;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double elem:
             values) {
            sb.append(delimiter).append(elem);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
