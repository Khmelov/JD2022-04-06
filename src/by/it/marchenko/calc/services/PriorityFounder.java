package by.it.marchenko.calc.services;

import java.util.List;
import java.util.Map;

import static by.it.marchenko.calc.constant.MessageConst.*;

public class PriorityFounder {
    private final Map<String, Integer> operatorPriority;

    public PriorityFounder() {
        this.operatorPriority = Map.of(
                ASSIGN_OPERATOR, 0,
                ADD_OPERATOR, 1,
                SUB_OPERATOR, 1,
                MUL_OPERATOR, 2,
                DIV_OPERATOR, 2
        );
    }

    public int getPriority(List<String> operators) {
        int index = -1;
        int maxPriority = -1;
        for (int i = 0; i < operators.size(); i++) {
            int currentOperatorPriority = operatorPriority.get(operators.get(i));
            if (currentOperatorPriority > maxPriority) {
                maxPriority = currentOperatorPriority;
                index = i;
            }
        }
        return index;
    }
}
