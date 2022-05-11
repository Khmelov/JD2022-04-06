package by.it.marchenko.jd01_10.calc;

public class MessageConst {
    public static final String MESSAGE_GREETING = "Application started. Type expression or END for exit.";
    public static final String MESSAGE_EMPTY_EXPRESSION = "Incorrect input. Empty expression entered";
    public static final String MESSAGE_FAREWELL = "Application finished.";


    public static final String MESSAGE_PRINT_RESULT = "Result";
    public static final String MESSAGE_DATA_INVITATION = ">"
            .repeat(MESSAGE_PRINT_RESULT.length());
    public static final String COMMAND_APP_EXIT = "end";

    public static final String SPACES_REGEX = "\s*";
    public static final String OPERATOR_REGEX = "[-+*/]";
    public static final String SCALAR_PATTERN = "-?[0-9]+\\.?[0-9]*";
    public static final String VECTOR_PATTERN = "\\{" + SCALAR_PATTERN + "(," + SCALAR_PATTERN + ")*}";
    public static final String MATRIX_PATTERN = "\\{" + VECTOR_PATTERN + "(," + VECTOR_PATTERN + ")*}";

    public static final String EMPTY_STRING = "";

    public static final int MAXIMUM_ALLOWED_OPERANDS = 10;

    public static final String ADD_OPERATOR = "+";
    public static final String SUB_OPERATOR = "-";
    public static final String MUL_OPERATOR = "*";
    public static final String DIV_OPERATOR = "/";

    public static final String ADD_STRING_OPERATOR = "add";
    public static final String SUB_STRING_OPERATOR = "sub";
    public static final String MUL_STRING_OPERATOR = "mul";
    public static final String DIV_STRING_OPERATOR = "div";

}
