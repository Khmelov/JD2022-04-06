package by.it.annazhegulovich.jd02_04.calc.repository;

import by.it.annazhegulovich.jd02_04.calc.entity.Var;
import by.it.annazhegulovich.jd02_04.calc.interfaces.Repository;

import java.util.HashMap;
import java.util.Map;

public class VarMapRepository implements Repository {
    private  final Map<String, Var> vars = new HashMap<>();

    @Override
    public Var save(String name, Var value) {
        vars.put(name, value);
        return value;
    }

    @Override
    public Var get(String name)  {
        return vars.get(name);
    }
}
