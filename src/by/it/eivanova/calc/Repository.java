package by.it.eivanova.calc;

public interface Repository {
    
    Var save(String name, Var value);
    Var get(String name);
}
