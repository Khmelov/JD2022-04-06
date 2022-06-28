package by.it.ragach.calc.constants;

import by.it.ragach.calc.Logger;
import by.it.ragach.calc.PathFinder;

public class Patterns {

    //-1*-2+-{-3,4}*-{{1,1,1}}--4

    public static final String OPERATION = "(?<=[^{,+=*/-])[-+*/=]";
    public static final String SPACES = "\\s+";
    public static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    public static final String MATRIX = "\\{"+VECTOR+"(,"+VECTOR+")*}";
    public static final String SIMPLE_EXP = "\\([^()]*\\)";
    public static final String LOG_PATH = PathFinder.getPath(Logger.class,"data_report.txt");
    public static final String REPORT_PATH = PathFinder.getPath(Logger.class,"log.txt");

}
