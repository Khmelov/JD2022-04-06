package by.it.marchenko.jd01_07;

abstract class Var {
    public static final String OPEN_CURVE_BRACKET = "{";
    public static final String CLOSE_CURVE_BRACKET = "}";
    public static final String OPEN_SQUARE_BRACKET = "\\[";
    public static final String CLOSE_SQUARE_BRACKET = "]";

    public static final String VECTOR_SEPARATOR = ", *";
    public static final String MATRIX_SEPARATOR = "} *, *\\{";




    @Override
    public String toString() {
        return "unknown variable(abstract stub)";
    }
}
