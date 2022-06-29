package by.it.machuga.calc.repasitory;

import by.it.machuga.calc.interfaces.Message;
import by.it.machuga.calc.runner.ConsoleRunner;
import by.it.machuga.calc.util.PathFinder;
import by.it.machuga.calc.servise.VarBuilder;
import by.it.machuga.calc.constans.ConstantStorage;
import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.exception.CalculatorException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static by.it.machuga.calc.runner.ConsoleRunner.*;

public class PersistentRepository implements Repository {

    private final File path;

    private final Map<String, Var> vars = new HashMap<>();

    public PersistentRepository() {
        String filename = PathFinder.getPath(ConsoleRunner.class, ConstantStorage.VARS_TXT);
        path = new File(filename);
        initFromFile();
    }

    private void initFromFile() {
        if (path.exists()) {
            VarBuilder creator = new VarBuilder(this);
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                while (true) {
                    String line = reader.readLine();
                    if (!Objects.isNull(line)) {
                        String[] parts = line.split(ConstantStorage.EQUALS, 2);
                        String name = parts[0];
                        Var var = creator.createVar(parts[1]);
                        vars.put(name, var);
                    } else {
                        break;
                    }
                }
            } catch (IOException e) {
                logger.error(resourceManager.get(Message.FILE_NOT_FOUND_MSG));
                reporter.collectReportError(ConstantStorage.FILE_NOT_FOUND, e);
                throw new RuntimeException(resourceManager.get(Message.FILE_NOT_FOUND_MSG), e);
            } catch (CalculatorException e) {
                logger.error(resourceManager.get(Message.CAN_T_PARSE_VAR_MSG));
                reporter.collectReportError(ConstantStorage.CAN_T_PARSE_VAR, e);
                throw new RuntimeException(resourceManager.get(Message.CAN_T_PARSE_VAR_MSG), e);
            }
        }
    }

    @Override
    public Var save(String name, Var value) throws CalculatorException {
        vars.put(name, value);
        saveToFile();
        return value;
    }

    private void saveToFile() throws CalculatorException {
        try (PrintWriter writer = new PrintWriter(path)) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                writer.printf(ConstantStorage.VAR_FORMAT, entry.getKey(), entry.getValue());
            }
        } catch (FileNotFoundException e) {
            logger.error(ConstantStorage.FILE_NOT_FOUND);
            reporter.collectReportError(ConstantStorage.FILE_NOT_FOUND, e);
            throw new CalculatorException(ConstantStorage.FILE_NOT_FOUND, e);
        }
    }

    @Override
    public Var get(String name) {
        return vars.get(name);
    }
}
