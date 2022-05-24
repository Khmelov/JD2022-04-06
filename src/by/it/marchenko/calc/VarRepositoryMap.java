package by.it.marchenko.calc;

import java.util.HashMap;

public class VarRepositoryMap implements Repository {
    private final static HashMap<String, Var> varMap = new HashMap<>();

    @Override
    public boolean saveVariable(String name, Var variable) {
        boolean result = true;
        if (varMap.containsKey(name)) {
            //TODO implement Printer method invocation
            //TODO change variable name as option
            //System.out.printf("The variable %s is already assigned. Do you want to overwrite value?(Y/N)", name);
            //TODO implement answers from console or other device
            String overwriteAnswer = "N".toLowerCase();
            if (overwriteAnswer.equals("n")) {
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
