package by.it.arsenihlaz.calculator.repository;

import by.it.arsenihlaz.calculator.ConsoleRunner;
import by.it.arsenihlaz.calculator.constants.Exception;
import by.it.arsenihlaz.calculator.entity.Var;
import by.it.arsenihlaz.calculator.exception.CalcException;
import by.it.arsenihlaz.calculator.interfaces.Repository;
import by.it.arsenihlaz.calculator.services.VarCreator;
import by.it.arsenihlaz.calculator.util.PathFinder;
import by.it.arsenihlaz.jd02_05.ResourceManager;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static by.it.arsenihlaz.calculator.constants.Patterns.VARS_TXT;

public class PersistentRepository implements Repository {

    private final File path;
    private final ResourceManager resourceManager = ResourceManager.INSTANSE;
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
                    Var var= creator.createVar(parts[1]);
                    vars.put(name, var);
                }
            } catch (IOException | CalcException e) {
                throw new RuntimeException(resourceManager.getValue(Exception.NOT_FOUND_FILE), e);
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
            throw new CalcException(resourceManager.getValue(Exception.NOT_FOUND_FILE), e);
        }
    }

    @Override
    public Var get(String name) {
        return vars.get(name);
    }
}
