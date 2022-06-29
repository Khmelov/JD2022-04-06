package by.it.annazhegulovich.jd02_04.calc.constans;

public class Patterns {
    public static final String OPERATION = "(?<=[^{,+=*/-])[-+*/=]";
    public static final String SPACES = "\\s+";
    public static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    public static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
    public static final String PRIORITY_SIMPLE = "\\([^()]*\\)";

}
