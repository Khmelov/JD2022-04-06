package by.it.ragach.calc;

import java.util.HashMap;
import java.util.Map;

public class VarMapRepository implements  Repository{


    private final Map<String,Var>vars = new HashMap<>();


    @Override
    public Var save(String name, Var value) throws CalcException {
        vars.put(name,value);
        return value;
    }

    @Override
    public Var get(String name)throws CalcException  {
        return vars.get(name);
    }
}
