package by.it.marchenko.calc.services;


import by.it.marchenko.calc.constant.LanguageConst;
import by.it.marchenko.calc.entity.Var;
import by.it.marchenko.calc.log.EnumLogger;
import by.it.marchenko.calc.log.LazyLogger;
import by.it.marchenko.calc.utility.ResourceManager;

public class Printer implements LanguageConst {
    private final ResourceManager resourceManager;

    public Printer(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    public static void print(String out) {
        System.out.println(out);
        EnumLogger.get().info(out);
        LazyLogger.get().info(out);
    }

    public void print(Input inputString, Var result) {

        if (inputString.getExpression() != null) {
            if (inputString.runEnabled()) {
                String message = String.format("%s % 2d: %s%n",
                        resourceManager.getString(MESSAGE_PRINT_RESULT),
                        inputString.getExpressionID(),
                        result);
                System.out.print(message);
                EnumLogger.get().result(message);
                LazyLogger.get().result(message);
            }
        }
    }

    public void greeting() {
        String message = resourceManager.getString(MESSAGE_GREETING);
        System.out.println(message);
        EnumLogger.get().info(message);
        LazyLogger.get().info(message);
    }
}
