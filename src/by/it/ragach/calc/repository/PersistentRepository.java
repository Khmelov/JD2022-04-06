package by.it.ragach.calc.repository;

import by.it.ragach.calc.ConsoleRunner;
import by.it.ragach.calc.PathFinder;
import by.it.ragach.calc.ResMan;
import by.it.ragach.calc.constants.Message;
import by.it.ragach.calc.service.VarCreator;
import by.it.ragach.calc.entity.Var;
import by.it.ragach.calc.exception.CalcException;
import by.it.ragach.calc.interfaces.Repository;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PersistentRepository implements Repository {

    private ResMan resMan = ResMan.INSTANCE;

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
                throw new RuntimeException(resMan.get(Message.FILE_NOT_FOUND_MESSAGE),e);

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


        try (PrintWriter printWriter = new PrintWriter(path)) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                printWriter.printf("%s=%s%n", entry.getKey(), entry.getValue());

            }
        } catch (FileNotFoundException e) {
            throw new CalcException(resMan.get(Message.FILE_NOT_FOUND_MESSAGE), e);
        }


    }


    @Override
    public Var get(String name)  {
        return vars.get(name);
    }
}
