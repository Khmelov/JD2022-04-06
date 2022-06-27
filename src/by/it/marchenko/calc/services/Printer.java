package by.it.marchenko.calc.services;


import by.it.marchenko.calc.ConsoleRunner;
import by.it.marchenko.calc.constant.LanguageConst;
import by.it.marchenko.calc.entity.Var;
import by.it.marchenko.calc.log.Log;
import by.it.marchenko.calc.log.report.ReportLogger;
import by.it.marchenko.calc.utility.ResourceManager;

public class Printer implements LanguageConst {
    private final ResourceManager resourceManager;
    private final Log logger;

    public Printer(ResourceManager resourceManager, Log logger) {
        this.resourceManager = resourceManager;
        this.logger = logger;
    }

    public String print(String out) {
        System.out.println(out);
        logger.info(out);
        return out;
    }

    public String print(Input inputString, Var result) {
        String message = null;
        if (inputString.getExpression() != null) {
            if (inputString.runEnabled()) {
                message = String.format("%s % 2d: %s%n",
                        resourceManager.getString(MESSAGE_PRINT_RESULT),
                        inputString.getExpressionID(),
                        result);
                System.out.print(message);
                logger.result(message);
            }
        }
        return message;
    }

    public void greeting() {
        String message = resourceManager.getString(MESSAGE_GREETING);
        System.out.println(message);
        logger.info(message);
    }
}