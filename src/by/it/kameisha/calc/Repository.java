package by.it.kameisha.calc;

public interface Repository {
    
    Var save(String name, Var value);

    Var get(String name);
}
