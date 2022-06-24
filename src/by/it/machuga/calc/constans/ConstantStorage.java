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
}
