package by.it.marchenko.calc;

import java.util.HashMap;

public interface Repository {
    boolean saveVariable(String name, Var variable);

    Var getVariable(String name);

    HashMap<String, Var> getAllVariables();
}
