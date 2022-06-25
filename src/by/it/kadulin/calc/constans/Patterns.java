package by.it.kadulin.calc.constans;

public class Patterns {

    // -1*-2+{-3,4}*-{{1,1,1}}--4
    // 2*(-2*2*(2*2))
    // (?<=[^{(,+=*/-])[=*/+-]
    // (2+2)
    // 2*(2*2*(2*2*(2*2)))
    public static final String OPERATIONS = "(?<=[^{,+=*/-])[-+/*=]";
    public static final String ROUND_BRACKETS = "\\([^\\(\\)]*\\)";
    public static final String SPACES = "\\s+";
    public static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR = "\\{" + SCALAR + "(,\\s*" + SCALAR + ")*}";
    public static final String MATRIX = "\\{" + VECTOR + "(,\\s*" + VECTOR + ")*}";

}
