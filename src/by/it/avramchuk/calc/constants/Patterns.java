package by.it.avramchuk.calc.constants;

import by.it.avramchuk.calc.logger.Logger;
import by.it.avramchuk.calc.util.PathFinder;

public class Patterns {


    // \([^\(\)]*\) - самые маленькие скобки
    // \(.*\) - самые большие скобки

    public static final String OPERATIONS = "(?<=[^{,+=*-/])[-+*/=]";
    public static final String SPACES = "\s+";
    public static final String SCALAR= "-?[0-9]+(.[0-9]+)?";
    public static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    public static final String MATRIX = "\\{"+VECTOR+"(,"+VECTOR+")*}";
    public static final String SIMPLE_EXP = "\\([^()]*\\)";
    public static final String REPORT_PATH = PathFinder.getPath(Logger.class,"data_report.txt");
    public static final String LOG_PATH = PathFinder.getPath(Logger.class,"log.txt");
    public static final String ERROR = "ERROR";

}
