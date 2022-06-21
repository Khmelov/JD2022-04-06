package by.it.smirnov.calc.constants;

public class Patterns {

    public static final String OPERATION = "(?<=[^{,+=*/-])[-+*/=]";
    public static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    public static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    public static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";

    public static final String IN_BRACES = "\\([{a-zA-Z0-9,.}]+[-+*/]+[{a-zA-Z0-9,.}]+\\)";
}
/*C=B+(A*2)
D=((C-0.15)-20)/((7-5)-(9-0))
E={2,3}*(D/2)+({1.0,2.0,4.0}+{{1,2},{3,4}})
((2+3)-1)
*/
