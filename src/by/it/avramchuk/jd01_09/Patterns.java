package by.it.avramchuk.jd01_09;

public class Patterns {

    public static final String OPERATIONS = "[-+*/]";
    public static final String SPACES = "\s+";
    public static final String SCALAR= "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR = "\\{"+SCALAR+"(,"+SCALAR+")*\\}";
    public static final String MATRIX = "\\{"+VECTOR+"(,"+VECTOR+")*\\}";

}
