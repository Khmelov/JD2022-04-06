package by.it.smirnov.calc.repository;

import by.it.smirnov.calc.entity.Var;
import by.it.smirnov.calc.interfaces.Repository;

import java.util.HashMap;
import java.util.Map;

public class VarRepository implements Repository {

    private final Map<String, Var> vars = new HashMap<>();
@Override
    public Var saveVar(String name, Var variable){
        vars.put(name, variable);
        return variable;
    }

    @Override
    public Var get(String name) {
        return vars.get(name);
    }
}
