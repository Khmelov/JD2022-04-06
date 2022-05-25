package by.it.marchenko.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.marchenko.calc.MessageConst.*;

public class Parser {

    private final Repository repository;
    private final VarCreator varCreator;
    private final Operands operands;
    private final Assignment assignment;


    public Parser(Repository repository, VarCreator varCreator, Operands operands, Assignment assignment) {
        this.repository = repository;
        this.varCreator = varCreator;
        this.operands = operands;
        this.assignment = assignment;
    }

    List<String> operatorList;
    List<Var> operandList;

    @SuppressWarnings("ConstantConditions")
    public Var calc(String inputString) throws CalcException {

        if (inputString != null) {
            // remove spaces
            ArrayList<String> stringsOperands = operands.createOperands(inputString);
            ArrayList<String> operators = operands.createOperators(inputString);


            //boolean assign = assignment.isAssignmentAllowed(inputString, stringsOperands);
            if (assignment.isAssignmentAllowed(inputString, stringsOperands)) {
                //TODO transferToLeft(myOperands,inputString);
                // Result: A=1+2*3
                return performAssignment(stringsOperands, operators);
                /*
                String stdExpression = toStdPresentation(stringsOperands, operators);
                String[] temp = stdExpression.split(ASSIGN_OPERATOR);
                String name = temp[0];
                Var value = calc(temp[1]);
                repository.saveVariable(name,value);
                return repository.getVariable(name);
                //return assignment.performAssignment(stringsOperands, operators);


                 */
            }

            operandList = new ArrayList<>(stringsOperands.size());
            operatorList = new ArrayList<>(stringsOperands.size() - 1);

            Pattern operatorPattern = Pattern.compile(OPERATOR_REGEX);
            Matcher operatorMatcher1 = operatorPattern.matcher(inputString);
            for (String operand : stringsOperands) {
                //operand = operand.trim();
                operandList.add(varCreator.createVar(operand));
                if (operatorMatcher1.find()) {
                    operatorList.add(operatorMatcher1.group());
                }
            }
            Var tempResult = operandList.get(0);

            for (int i = 0; i < operatorList.size(); i++) {
                tempResult = switch (operatorList.get(i)) {
                    // TODO NullPointerException during invocation
                    case ADD_OPERATOR -> tempResult.add(operandList.get(i + 1));
                    case SUB_OPERATOR -> tempResult.sub(operandList.get(i + 1));
                    case MUL_OPERATOR -> tempResult.mul(operandList.get(i + 1));
                    case DIV_OPERATOR -> tempResult.div(operandList.get(i + 1));
                    //case ASSIGN_OPERATOR -> AssignMethod();
                    default -> null;
                };
            }
            return tempResult;
        }
        return null;
    }

    private String toStdPresentation(ArrayList<String> operands, ArrayList<String> operators) {
        StringBuilder tempExpression = new StringBuilder(operands.get(0));
        for (int i = 0; i < operators.size(); i++) {
            tempExpression
                    .append(operators.get(i))
                    .append(operands.get(i + 1));
        }
        return tempExpression.toString();
    }

    private Var performAssignment(ArrayList<String> operands, ArrayList<String> operators) throws CalcException {
        String stdExpression = toStdPresentation(operands, operators);
        String[] temp = stdExpression.split(ASSIGN_OPERATOR);
        String name = temp[0];
        Var value = calc(temp[1]);
        repository.saveVariable(name,value);
        return repository.getVariable(name);
    }
}
    /*
    private List<String> AssignMethod(List<String> operatorList) {
        int assignPosition = operatorList.indexOf(ASSIGN_OPERATOR);
        //int lastAssignPosition = operatorList.lastIndexOf(ASSIGN_OPERATOR);

        if (isUnique(operatorList, ASSIGN_OPERATOR) &&
                isUnique(operandList, null)) {
            //assignation
            //transferToLeft(assignPosition);
            System.out.println("Perform assignation");
        }
        return operatorList;
    }


    private void transferToLeft(int position) {
        List<String> tempOperatorList = new ArrayList<>(operatorList.size());

        String[] tempOperands = Arrays.copyOf(operands, operands.length);
        //a: 1+2*A = 3-4/5      b: A+1*2 = 3-4/5
        //    + *  =  - /           + *  =  - /
        //   1 2 n   3 4 5         n 1 2   3 4 5
        //   3 4 5 -(1) (2)
        //   = - / (+) (*)
        tempOperatorList.addAll(operatorList.subList(position, operatorList.size()));
        System.arraycopy(operands, position, tempOperands, 0, operands.length - position);
        System.arraycopy(operands, 0, tempOperands, operands.length - position, position);

        System.out.println(Arrays.toString(tempOperands));

        System.out.println(tempOperatorList);
    }


 */

