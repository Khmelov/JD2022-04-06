package by.it.machuga.calc.constans;

public class ConstantStorage {
    public static final String OPERATION = "(?<=[^{,+=*/-])[-+*/=]";
    public static final String SCALAR_REGEX = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR_REGEX = "\\{(" + SCALAR_REGEX + ",? ?)+}";
    public static final String MATRIX_REGEX = "\\{(" + VECTOR_REGEX + ",? ?)+}";
    public static final String SIMPLE_EXPRESSION_REGEX = "\\([^()]+\\)";
    public static final String CURLY_BRACES = "[{}]";
    public static final String OPEN_BRACE = "(";
    public static final String CLOSE_BRACE = ")";
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
    public static final String USER_DIR = "user.dir";
    public static final String VARS_TXT = "vars.txt";
    public static final String EQUALS = "=";
    public static final String FILE_NOT_FOUND_MSG = "File not found";
    public static final String CAN_T_PARSE_VAR_MSG = "Can't parse var";
    public static final String ERROR_MSG = "ERROR: ";
    public static final String AND = " and ";
    public static final String BY = " by ";
    public static final String CANNOT_DIVIDE_MSG = "Cannot divide ";
    public static final String UNKNOWN_VARIABLE_ABSTRACT_STUB_MSG = "unknown variable (abstract stub)";
    public static final String CANNOT_MULTIPLY_MSG = "Cannot multiply ";
    public static final String CANNOT_SUBTRACT_MSG = "Cannot subtract ";
    public static final String CANNOT_ADD_MSG = "Cannot add ";
    public static final String INCORRECT_STRING_MSG = "Incorrect string %s";
}
