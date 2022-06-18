package by.it.marchenko.calc.repository;

import by.it.marchenko.calc.entity.Var;
import by.it.marchenko.calc.interfaces.Repository;

import java.util.HashMap;
import java.util.Scanner;

import static by.it.marchenko.calc.constant.MessageConst.*;


public class VarRepositoryMap implements Repository {
    private final static HashMap<String, Var> varMap = new HashMap<>();

    private final Scanner console;

    public VarRepositoryMap(Scanner console) {
        this.console = console;
    }

    @Override
    public boolean saveVariable(String name, Var variable) {
        boolean result = true;
        if (varMap.containsKey(name)) {
            //TODO implement Printer method invocation
            //TODO change variable name as option
            String answer;
            do {
                System.out.printf(MESSAGE_OVERWRITE_VALUE, name);
                answer = console.nextLine().toLowerCase().trim();
            } while (!YES_ANSWER.contains(answer) && !NO_ANSWER.contains(answer));
            if (NO_ANSWER.contains(answer)) {
                result = false;
            }
        }
        if (result) {
            varMap.put(name, variable);
        }
        return result;
    }

    @Override
    public Var getVariable(String name) {
        return varMap.get(name);
    }

    @Override
    public HashMap<String, Var> getAllVariables() {
        return new HashMap<>(varMap);
    }
}
