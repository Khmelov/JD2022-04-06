package by.it._classwork_.calc.repository;

import by.it._classwork_.calc.ConsoleRunner;
import by.it._classwork_.calc.entity.Var;
import by.it._classwork_.calc.exception.CalcException;
import by.it._classwork_.calc.interfaces.Repository;
import by.it._classwork_.calc.service.VarCreator;
import by.it._classwork_.calc.util.PathFinder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PersistentRepository implements Repository {

    public static final String VARS_TXT = "vars.txt";
    private final File path;

    private final Map<String, Var> vars = new HashMap<>();

    public PersistentRepository() {
        String filename = PathFinder.getPath(ConsoleRunner.class, VARS_TXT);
        path = new File(filename);
        initFromFile();
    }

    private void initFromFile() {
        if (path.exists()) {
            VarCreator creator = new VarCreator(this);
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                while (reader.ready()) {
                    String line = reader.readLine();
                    String[] parts = line.split("=", 2);
                    String name = parts[0];
                    Var var = creator.createVar(parts[1]);
                    vars.put(name, var);
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
