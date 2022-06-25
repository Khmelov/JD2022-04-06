package by.it.kadulin.calc.repository;

import by.it.kadulin.calc.ConsoleRunner;
import by.it.kadulin.calc.entity.Var;
import by.it.kadulin.calc.interfaces.Repository;
import by.it.kadulin.calc.service.VarCreator;
import by.it.kadulin.calc.util.PathFinder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
                while (reader.ready()) {
                    String line = reader.readLine();
                    String[] parts = line.split("=");
                    String name = parts[0];
                    Var var = creator.createVar(parts[1]);
                    vars.put(name, var);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Var save(String name, Var value) {
        vars.put(name, value);
        saveToFile();
        return value;
    }

    private void saveToFile() {
        try (PrintWriter printWriter = new PrintWriter(path)) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                printWriter.printf("%s=%s%n", entry.getKey(), entry.getValue());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Var get(String name) {
        return vars.get(name);
    }

}
