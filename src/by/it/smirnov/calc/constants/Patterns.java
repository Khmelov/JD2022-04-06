package by.it.smirnov.calc.constants;

public class Patterns {
    private Patterns() {
    }

    public static final String OPERATION = "(?<=[^{,+=*/-])[-+*/=]";
    public static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    public static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    public static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
    public static final String IN_BRACES = "\\([{a-zA-Z0-9,.}]+[-+*/]+[{a-zA-Z0-9,.}]+\\)";
    public static final String BRACES = "[)(]";
    public static final String SPACES = "\\s+";
}
