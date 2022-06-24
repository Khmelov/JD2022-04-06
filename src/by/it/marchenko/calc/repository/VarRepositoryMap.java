package by.it.marchenko.calc.repository;

import by.it.marchenko.calc.entity.Var;
import by.it.marchenko.calc.interfaces.Repository;

import java.util.HashMap;


public class VarRepositoryMap implements Repository {
    private final static HashMap<String, Var> varMap = new HashMap<>();

    public VarRepositoryMap() {
    }

    @Override
    public boolean saveVariable(String name, Var variable) {
        boolean result = true;
        if (varMap.containsKey(name)) {
            //TODO implement Printer method invocation
            //TODO change variable name as option
            @SuppressWarnings("unused") String answer;
            /*do {
                System.out.printf(MESSAGE_OVERWRITE_VALUE, name);
                answer = console.nextLine().toLowerCase().trim();
            } while (!YES_ANSWER.contains(answer) && !NO_ANSWER.contains(answer));
            if (NO_ANSWER.contains(answer)) {
                result = false;
            }*/
        }
        //noinspection ConstantConditions
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

    @Override
    public void clearRepository() {
        varMap.clear();
    }
}
