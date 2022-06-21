package by.it.avramchuk.calc.constants;

public class Patterns {


    // \([^\(\)]*\) - самые маленькие скобки
    // \(.*\) - самые большие скобки

    public static final String OPERATIONS = "(?<=[^{,+=*-/])[-+*/=]";
    public static final String SPACES = "\s+";
    public static final String SCALAR= "-?[0-9]+(.[0-9]+)?";
    public static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    public static final String MATRIX = "\\{"+VECTOR+"(,"+VECTOR+")*}";
    public static final String SIMPLE_EXP = "\\([^()]*\\)";

}
