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
    public static final String EMPTY_SPACE = " ";
    public static final String COMMA_SPACE = ",\\s*";
    public static final String SPACE = "\\s+";
    public static final String NEW_LINE = "\n";
    public static final String LEFT_CURLY_BRACE = "{";
    public static final String RIGHT_CURLY_BRACE = "}";
    public static final String COMMA_SPACE_APPENDER = ", ";
    public static final String USER_DIR = "user.dir";
    public static final String VARS_TXT = "vars.txt";
    public static final String EQUALS = "=";
    public static final String PATH = "by/it/machuga/calc/localization/language.text";
    public static final String SELECT_LANGUAGE_MSG = """
            Select language | Выберите язык | Выберыце мову
            English | Русский язык | Беларуская мова
            EN | RU | BE
            --->""";
    public static final String RU_LANGUAGE = "ru";
    public static final String BE_LANGUAGE = "be";
    public static final String EN_LANGUAGE = "en";
    public static final String RU_COUNTRY = "RU";
    public static final String BY_COUNTRY = "BY";
    public static final String US_COUNTRY = "US";
    public static final String OPERATION_ADD_FAILED = "Operation ADD failed";
    public static final String OPERATION_SUB_FAILED = "Operation SUB failed";
    public static final String OPERATION_MUL_FAILED = "Operation MUL failed";
    public static final String OPERATION_DIV_FAILED = "Operation DIV failed";
    public static final String VAR_FORMAT = "%s=%s%n";
    public static final String FILE_NOT_FOUND = "File not found";
    public static final String CAN_T_PARSE_VAR = "Can't parse var";
    public static final String APPLICATION_STARTED_AT_ = "Application started at ";
    public static final String APPLICATION_STOPPED_AT_ = "Application stopped at ";
    public static final String ERROR = "ERROR: ";
    public static final String INFO = "INFO: ";
    public static final String SELECT_REPORT_TYPE_FULL_OR_SHORT = "Select report type: FULL or SHORT";
    public static final String FULL = "full";
    public static final String FILENAME = "log.txt";
    public static final String ERROR_FORMAT = "ERROR: %s %s";
    public static final String INFO_FORMAT = "INFO: %s %s";
    public static final String FORMAT_TIME = "HH.mm.ss dd.MM.yyyy";
    public static final String APPLICATION_STARTED_MSG = "Application started";
    public static final String APPLICATION_STOPPED_MSG = "Application stopped";
    public static final String USER_ENTERED_EXPRESSION = "User entered expression ";
    public static final String CALCULATION_RESULT = "Calculation result ";
    public static final String CALCULATION_FAILED = "Calculation failed";
    public static final String USED_LOCALE = "Used locale ";
    public static final String INCORRECT_STRING = "Incorrect String";
    public static final String SRC = "src";
}
