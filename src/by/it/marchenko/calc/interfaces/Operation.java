package by.it.marchenko.calc.interfaces;

import by.it.marchenko.calc.entity.Matrix;
import by.it.marchenko.calc.entity.Scalar;
import by.it.marchenko.calc.entity.Var;
import by.it.marchenko.calc.entity.Vector;

public interface Operation {
    // these methods are the same
    Var foundVarType(Var operand, String operator);

    Var foundVarType(Scalar operand, String operator);

    Var foundVarType(Vector operand, String operator);

    Var foundVarType(Matrix operand, String operator);

    Var add(Scalar other);

    Var add(Vector other);

    Var add(Matrix other);

    //Var add(Var other);

    Var mul(Var other);
    Var div(Var other);
    // Var typeFounder (Var other, String operator){
    //    return other.operation(this, operator);
    // }

    // switch operator-> add, mul, div

    Var sub(Var other);

    Var mul(Scalar other);

    Var mul(Vector other);

    Var mul(Matrix other);

    Var div(Scalar other);

    Var div(Vector other);

    Var div(Matrix other);


}