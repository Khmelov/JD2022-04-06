package by.it.smirnov.calc.repository;

import by.it.smirnov.calc.ConsoleRunner;
import by.it.smirnov.calc.entity.Var;
import by.it.smirnov.calc.exception.CalcException;
import by.it.smirnov.calc.interfaces.Repository;
import by.it.smirnov.calc.service.VarCreator;
import by.it.smirnov.calc.util.PathGetter;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PersistentRepository implements Repository {
    private Map<String, Var> vars = new HashMap<>();
    private final File path;

    public PersistentRepository() {
        String fileName = PathGetter.getPath(ConsoleRunner.class, "Vars.txt");
        path = new File(fileName);
        initFromFile();
    }

    private void initFromFile() {
        if (path.exists()){
            VarCreator varCreator = new VarCreator(this);
            try (BufferedReader reader = new BufferedReader (new FileReader(path))){
                while (reader.ready()){
                    String line = reader.readLine();
                    String [] parts = line.split("=", 2);
                    String name = parts[0];
                    Var var = varCreator.createVar(parts[1]);
                    vars.put(name, var);
                }
            } catch (IOException | CalcException e) {
                throw new RuntimeException("File not found", e);
            }
        }
    }

    @Override
    public Var saveVar(String name, Var var) throws CalcException {
        vars.put(name, var);
        writeToFile();
        return var;
    }

    private void writeToFile() throws CalcException {
        try (PrintWriter printWriter = new PrintWriter(path)){
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                printWriter.printf("%s=%s%n", entry.getKey(), entry.getValue());
            }

        } catch (FileNotFoundException e) {
            throw new CalcException("File not found", e);
        }
    }

    @Override
    public Var get(String name) {
        return vars.get(name);
    }
}
