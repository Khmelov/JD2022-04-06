package by.it.arsenihlaz.calculator.constants;

public class Patterns {
    // -1*-2+ {-3,4}*-{{1,1,1}}--4
    public static final String MATH_OPERATIONS = "(?<=[^{,+=*/-])[-+*/=]";
    public static final String SPACES = "\\s+";
    public static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    public static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";

    public static final String VARS_TXT = "vars.txt";
}
