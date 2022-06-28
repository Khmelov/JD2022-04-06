package by.it.marchenko.calc.constant;

import by.it.marchenko.calc.entity.Scalar;

import java.util.Arrays;
import java.util.HashSet;

public class MessageConst {
    public static final HashSet<String> YES_ANSWER = new HashSet<>(Arrays.asList("yes", "y", "н", "нуы"));
    public static final HashSet<String> NO_ANSWER = new HashSet<>(Arrays.asList("no", "n", "т", "тщ"));

    public static final String MESSAGE_GREETING = "Application started. Type expression or END for exit.";
    public static final String MESSAGE_EMPTY_EXPRESSION = "Incorrect input. Empty expression entered";
    public static final String MESSAGE_OVERWRITE_VALUE =
            "The variable %s is already assigned. Do you want to overwrite value? (Y/N) ";
    public static final String MESSAGE_FAREWELL = "Application finished.";

    public static final String INPUT_EXCEPTION = "Incorrect input: ";
    public static final String EMPTY_OPERAND_EXCEPTION = "Empty operand entered";
    public static final String EMPTY_OPERAND_COMMENT =
            "\n  Reason: it is necessary to have operand between operators.";

    public static final String WRONG_OPERAND_EXCEPTION = "Wrong operand entered";
    public static final String WRONG_OPERAND_COMMENT =
            "\n  Reason: The operand %s is incorrect.";

    public static final String EMPTY_EXPRESSION_EXCEPTION = "Empty expression entered";
    public static final String EMPTY_EXPRESSION_COMMENT =
            "\n  Reason: expression not contain any significant symbol.";

    public static final String MISSING_OPERATOR_EXCEPTION = "Expression is incorrect";
    public static final String MISSING_OPERATOR_COMMENT =
            "\n  Reason: Incorrect/missing operator or incorrect operand: %s";

    public static final String ASSIGNMENT_EXCEPTION = "Incorrect assignment: ";
    public static final String ASSIGNMENT_OPERATOR_EXCEPTION =
            "More than one assignment operator \"%s\" in the expression%n  Expression: %s";
    public static final String ASSIGNMENT_OPERATOR_COMMENT =
            "\n  Reason: it is necessary to have only one assignment operator in the expression.";

    public static final String ASSIGNMENT_OPERAND_EXCEPTION =
            "More than one unknown variable in the expression%n  Expression: %s";
    public static final String ASSIGNMENT_OPERAND_COMMENT =
            "\n  Reason: it is necessary to have only one new variable in the expression.";

    public static final String ASSIGNMENT_NO_VAR_EXCEPTION =
            "Nothing to assign%n  Expression: %s";
    public static final String ASSIGNMENT_NO_VAR_COMMENT =
            "\n  Reason: it is necessary to have any Var for assign.";


    public static final String ASSIGNMENT_VARIABLE_EXCEPTION =
            "No unknown variable in the expression%n  Expression: %s";
    public static final String ASSIGNMENT_VARIABLE_COMMENT =
            "\n  Reason: it is necessary to have variable in the expression.";


    public static final String MESSAGE_PRINT_RESULT = "Result";
    public static final String MESSAGE_DATA_INVITATION = ">"
            .repeat(MESSAGE_PRINT_RESULT.length());

    public static final String COMMAND_APP_EXIT = "end";
    public static final String COMMAND_PRINT_VARIABLE = "printvar";
    public static final String COMMAND_SORT_VARIABLE = "sortvar";

    public static final String SPACES_REGEX = "\s*";
    public static final String OPERATORS = "[-=+*/]";
    public static final String OPERATOR_REGEX = "(?<=[^{,/*+-])" + OPERATORS;

    public static final String SCALAR_PATTERN = "-?[0-9]+\\.?[0-9]*";
    public static final String VARIABLE_PATTERN = "-?\s*([A-Z_a-zА-Яа-яЁё])([А-Яа-яЁё\\w]*)";
    public static final String VECTOR_PATTERN =
            "-?\s*\\{\s*" + SCALAR_PATTERN + "\s*(,\s*" + SCALAR_PATTERN + "\s*)*}";
    public static final String MATRIX_PATTERN =
            "-?\s*\\{\s*" + VECTOR_PATTERN + "\s*(,\s*" + VECTOR_PATTERN + "\s*)*}";

    public static final String OPEN_CURVE_BRACKET = "\\(";
    public static final String CLOSE_CURVE_BRACKET = "\\)";
    //public static final String CURVE_EXPRESSION_REGEX = "(\\()([^\\(]+?)(\\))";
    public static final String CURVE_EXPRESSION_REGEX =
            OPEN_CURVE_BRACKET + "([^" + OPEN_CURVE_BRACKET + "]+?)" + CLOSE_CURVE_BRACKET;

    public static final String EMPTY_STRING = "";

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
