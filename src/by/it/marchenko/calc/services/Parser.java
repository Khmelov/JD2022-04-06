package by.it.marchenko.calc.services;

import by.it.marchenko.calc.entity.Var;
import by.it.marchenko.calc.exception.CalcException;
import by.it.marchenko.calc.interfaces.Repository;
import by.it.marchenko.calc.utility.CurveChecker;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.marchenko.calc.constant.MessageConst.*;

public class Parser {

    private final Repository repository;
    //private final VarCreator varCreator;
    private final Operands operands;
    private final Assignment assignment;

    private final PriorityFounder priorityFounder;
    private final CurveChecker curveChecker = new CurveChecker();


    public Parser(Repository repository, /*VarCreator varCreator,*/ Operands operands, Assignment assignment) {
        this.repository = repository;
        //this.varCreator = varCreator;
        this.operands = operands;
        this.assignment = assignment;
        this.priorityFounder = new PriorityFounder();
    }

    //List<Var> operandList;

    public Var calc(String inputString) throws CalcException {
        if (!curveChecker.checkCurves(inputString)) {
            throw new CalcException("Incorrect curve placement");
        }
        System.out.println("Correct curves");
        Pattern curveExpressionPattern = Pattern.compile(CURVE_EXPRESSION_REGEX);
        Matcher curveExpressionMatcher = curveExpressionPattern.matcher(inputString);
        while (curveExpressionMatcher.find()) {
            String curveExpression = curveExpressionMatcher.group();
            String substring = curveExpression.substring(1, curveExpression.length() - 1);
            String calcResult = calc(substring).toString();
            inputString = inputString.replace(curveExpression, calcResult);
            System.out.println(inputString);
            curveExpressionMatcher = curveExpressionPattern.matcher(inputString);

        }
        return calcInCurves(inputString);
    }

    private Var calcInCurves(String inputString) throws CalcException {
        // TODO calc if only one var typed
        Var result = null;
        if (inputString != null) {
            List<String> stringsOperands = operands.createOperands(inputString);
            List<String> operators = operands.createOperators(inputString);
            if (assignment.isAssignmentAllowed(inputString, stringsOperands)) {
                return performAssignment(stringsOperands, operators);
            }
            if (operators.isEmpty()) {
                return operands.createVar(inputString);
            }
            List<Var> operandList = operands.createVar(stringsOperands);
            while (!operators.isEmpty()) {
                int priorityIndex = priorityFounder.getPriority(operators);
                String operator = operators.remove(priorityIndex);
                Var leftPart = operandList.remove(priorityIndex);
                Var rightPart = operandList.remove(priorityIndex);
                result = simplyCalc(leftPart, operator, rightPart);
                //System.out.println(leftPart + operator + rightPart + "=" + result);
                operandList.add(priorityIndex, result);
            }
        }
        return result;
    }

    private Var simplyCalc(Var leftPart, String operator, Var rightPart) {
        Var tempResult = leftPart;
        // now tempResult2 use only for add calculation.
        Var tempResult2 = leftPart.foundVarType(rightPart, operator);
        try {
            tempResult = switch (operator) {
                // TODO NullPointerException during invocation
                //case ADD_OPERATOR -> tempResult.add(rightPart);
                case SUB_OPERATOR -> tempResult.sub(rightPart);
                case MUL_OPERATOR -> tempResult.mul(rightPart);
                case DIV_OPERATOR -> tempResult.div(rightPart);
                //case ASSIGN_OPERATOR -> AssignMethod();
                default -> null;
            };
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return Objects.isNull(tempResult) ? tempResult2 : tempResult;
    }

    private String toStdPresentation(List<String> operands, List<String> operators) {
        StringBuilder tempExpression = new StringBuilder(operands.get(0));
        for (int i = 0; i < operators.size(); i++) {
            tempExpression
                    .append(operators.get(i))
                    .append(operands.get(i + 1));
        }
        return tempExpression.toString();
    }

    private Var performAssignment(List<String> operands, List<String> operators) throws CalcException {
        //TODO transferToLeft(myOperands,operators);
        // Input:   A-1=2*3
        // Result:  A=2*3+1
        String stdExpression = toStdPresentation(operands, operators);
        String[] temp = stdExpression.split(ASSIGN_OPERATOR);
        String name = temp[0];
        Var value = calc(temp[1]);
        boolean varCorrectlySaved = repository.saveVariable(name, value);
        if (!varCorrectlySaved) {
            throw new CalcException("Variable was nod saved");
        }
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

