package by.it.kameisha.calc;

import java.util.HashMap;
import java.util.Map;

public class VarMapRepositiry implements Repository{

public Map<String,Var> vars =  new HashMap<>();

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
