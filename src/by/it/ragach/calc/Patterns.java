package by.it.ragach.calc;

public class Patterns {

    //-1*-2+-{-3,4}*-{{1,1,1}}--4

    public static final String OPERATION = "(?<=[^{,+=*/-])[-+*/=]";
    public static final String SPACES = "\\s+";
    public static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    public static final String MATRIX = "\\{"+VECTOR+"(,"+VECTOR+")*}";
}
