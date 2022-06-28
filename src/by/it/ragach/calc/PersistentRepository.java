package by.it.ragach.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PersistentRepository implements Repository {

    private final File path;

    private final Map<String, Var> vars = new HashMap<>();


    public PersistentRepository() {
        String filename = PathFinder.getPath(ConsoleRunner.class, SingletonEnum.INSTANCE.getRESULT_TXT());
        path = new File(filename);
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
                throw new RuntimeException(e);

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
            throw new RuntimeException("not found file", e);
        }


    }


    @Override
    public Var get(String name) throws CalcException {
        return vars.get(name);
    }
}
