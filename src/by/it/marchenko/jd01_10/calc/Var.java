package by.it.marchenko.jd01_10.calc;

//import java.lang.reflect.*;

import static by.it.marchenko.jd01_09.MessageConst.*;

abstract class Var implements Operation {
    final String VAR_TO_STRING_MESSAGE = "Unknown variable(abstract stub)";

    @Override
    public Var add(Var other) {
        //Class<? extends Var> leftClass = this.getClass();
        //Class<? extends Var> rightClass = other.getClass();

        //Constructor<?>[] constructors = leftClass.getConstructors();
        //for (Constructor<?> constructor : constructors) {
        //    System.out.println(constructor);
            //constructor.
        //}

        //try {
        //    Constructor<? extends Var> constructor = rightClass.getConstructor(String.class);
        //    Object o = constructor.newInstance(other.toString());
        //    System.out.println("leftO "+o.getClass().getSimpleName());

            //Var var = constructor.newInstance(other.toString());
            //System.out.println(var.);
        //} catch (NoSuchMethodException e) {
        //    e.printStackTrace();
        //} catch (InvocationTargetException e) {
        //    e.printStackTrace();
        //} catch (InstantiationException e) {
        //    e.printStackTrace();
        //} catch (IllegalAccessException e) {
        //    e.printStackTrace();
        //}



        //System.out.println(leftClass.getSimpleName()+rightClass.getSimpleName());

        printNotAvailableOperation(ADD_OPERATOR, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        printNotAvailableOperation(SUB_OPERATOR, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        printNotAvailableOperation(MUL_OPERATOR, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        printNotAvailableOperation(DIV_OPERATOR, other);
        return null;
    }

    @Override
    public String toString() {
        return VAR_TO_STRING_MESSAGE;
    }

    private void printNotAvailableOperation(String operator, Var other) {
        final String INCORRECT_OPERATION_MESSAGE = "Operation %s %s %s not available.%n";
        System.out.printf(INCORRECT_OPERATION_MESSAGE, this, operator, other);
    }

    public static Var createVar(String operand) {
        if (operand.matches(SCALAR_PATTERN)){
            return new Scalar(operand);
        } else if (operand.matches(VECTOR_PATTERN)) {
            return new Vector(operand);
        }else if (operand.matches(MATRIX_PATTERN)) {
            return new Matrix(operand);
        }else{
            return null;
        }
    }

}
