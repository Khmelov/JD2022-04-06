package by.it.kameisha.calc.repository;

import by.it.kameisha.calc.entity.Var;
import by.it.kameisha.calc.interfaces.Repository;

import java.util.HashMap;
import java.util.Map;

public class VarMapRepository implements Repository {

public final Map<String, Var> vars =  new HashMap<>();

    @Override
    public Var save(String name, Var value) {
        vars.put(name,value);
        return value;
    }

    @Override
    public Var get(String name) {
        return vars.get(name);
    }
}
