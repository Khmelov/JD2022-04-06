package by.it.marchenko.calc.interfaces;

import by.it.marchenko.calc.entity.Var;

import java.util.HashMap;

public interface Repository {

    boolean saveVariable(String name, Var variable);

    Var getVariable(String name);

    HashMap<String, Var> getAllVariables();
}
