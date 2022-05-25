package by.it.marchenko.calc;

public class MessageConst {
    public static final String MESSAGE_GREETING = "Application started. Type expression or END for exit.";
    public static final String MESSAGE_EMPTY_EXPRESSION = "Incorrect input. Empty expression entered";
    public static final String MESSAGE_FAREWELL = "Application finished.";

    public static final String INPUT_EXCEPTION = "Incorrect input: ";
    public static final String EMPTY_OPERAND_EXCEPTION = "Empty operand entered";
    public static final String EMPTY_OPERAND_COMMENT =
            "\n  Reason: it is necessary to have operand between operators.";
    public static final String EMPTY_EXPRESSION_EXCEPTION = "Empty expression entered";
    public static final String EMPTY_EXPRESSION_COMMENT =
            "\n  Reason: expression not contain any significant symbol.";

    public static final String MISSING_OPERATOR_EXCEPTION = "Incorrect or missing operator";
    public static final String MISSING_OPERATOR_COMMENT =
            "\n  Reason: It was detected incorrect or missing operator between operands: %s";



    public static final String MESSAGE_PRINT_RESULT = "Result";
    public static final String MESSAGE_DATA_INVITATION = ">"
            .repeat(MESSAGE_PRINT_RESULT.length());

    public static final String COMMAND_APP_EXIT = "end";
    public static final String COMMAND_PRINT_VARIABLE = "printvar";
    public static final String COMMAND_SORT_VARIABLE = "sortvar";

    public static final String SPACES_REGEX = "\s*";
    public static final String OPERATOR_REGEX = "[-=+*/]";

    public static final String SCALAR_PATTERN = "-?[0-9]+\\.?[0-9]*";
    public static final String VARIABLE_PATTERN = "([A-Z_a-z])(\\w*)";
    public static final String VECTOR_PATTERN =
            "\\{\s*" + SCALAR_PATTERN + "\s*(,\s*" + SCALAR_PATTERN + "\s*)*}";
    public static final String MATRIX_PATTERN =
            "\\{\s*" + VECTOR_PATTERN + "\s*(,\s*" + VECTOR_PATTERN + "\s*)*}";


    public static final String EMPTY_STRING = "";

    public static final int MAXIMUM_ALLOWED_OPERANDS = 2;

    public static final String ADD_OPERATOR = "+";
    public static final String SUB_OPERATOR = "-";
    public static final String MUL_OPERATOR = "*";
    public static final String DIV_OPERATOR = "/";
    public static final String ASSIGN_OPERATOR = "=";


    public static final String ADD_STRING_OPERATOR = "add";
    //public static final String SUB_STRING_OPERATOR = "sub";
    public static final String MUL_STRING_OPERATOR = "mul";
    public static final String DIV_STRING_OPERATOR = "div";

}
