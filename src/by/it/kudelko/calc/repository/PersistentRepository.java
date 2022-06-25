package by.it.kudelko.calc.repository;

import by.it.kudelko.calc.ConsoleRunner;
import by.it.kudelko.calc.entity.Var;
import by.it.kudelko.calc.exception.CalcException;
import by.it.kudelko.calc.interfaces.Repository;
import by.it.kudelko.calc.service.VarCreator;
import by.it.kudelko.calc.util.PathFinder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class PersistentRepository implements Repository {

    public static final String VARS_TXT = "vars.txt";
    private final File path;

    private final Map<String, Var> vars = new HashMap<>();

    public PersistentRepository() {
        String fileName = PathFinder.getPath(ConsoleRunner.class, VARS_TXT);
        path = new File(fileName);
        initFromFile();
    }

    private void initFromFile() {
        if (path.exists()) {
            VarCreator creator = new VarCreator(this);
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                while (true) {
                    String line = reader.readLine();
                    if (!Objects.isNull(line)) {
                        String[] parts = line.split("=", 2);
                        String name = parts[0];
                        Var var = creator.createVar(parts[1]);
                        vars.put(name, var);
                    } else {
                        break;
                    }
                }
            } catch (IOException | CalcException e) {
                throw new RuntimeException("not found file", e);
            }
        }
    }


    @Override
    public Var save(String name, Var value) throws CalcException {
        vars.put(name, value);
        saveToFile();
        return value;
    }

    private void saveToFile() throws CalcException {
        try (PrintWriter writer = new PrintWriter(path)) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                writer.printf("%s=%s%n", entry.getKey(), entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new CalcException("not found file", e);
        }
        ;
    }

    @Override
    public Var get(String name) {
        return vars.get(name);
    }
}
