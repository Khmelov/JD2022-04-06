package by.it.machuga.jd01_09;

public class ConstantStorage {
    public static final String OPERATION = "[-+/*]";
    public static final String SCALAR_REGEX = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR_REGEX = "\\{(" + SCALAR_REGEX + ",? ?)+}";
    public static final String MATRIX_REGEX = "\\{(" + VECTOR_REGEX + ",? ?)+}";
    public static final String CURLY_BRACES = "[{}]";
    public static final String EMPTY_STRING = "";
    public static final String COMMA_SPACE = ",\\s*";
    public static final String SPACE = "\\s+";
    public static final String LEFT_CURLY_BRACE = "{";
    public static final String RIGHT_CURLY_BRACE = "}";
    public static final String COMMA_SPACE_APPENDER = ", ";
    public static final String END = "end";
    public static final String RESULT_MESSAGE = "Result: %s%n";
    public static final String CALCULATION_FAILED_MESSAGE = "Calculation failed";
    public static final String CALCULATOR_STARTED_MESSAGE = "Calculator started";
    public static final String CALCULATOR_STOPPED_MESSAGE = "Calculator stopped";
    public static final String ENTER_EXPRESSION_MESSAGE = "Enter expression or 'end' for exit";
}
