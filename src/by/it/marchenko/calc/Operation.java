package by.it.marchenko.calc;

interface Operation {
    // these methods are the same
    Var foundVarType(Var operand, String operator);
    Var foundVarType(Scalar operand, String operator);
    Var foundVarType(Vector operand, String operator);
    Var foundVarType(Matrix operand, String operator);


    Var add(Var other);
    Var mul(Var other);
    Var div(Var other);
    // Var typeFounder (Var other, String operator){
    //    return other.operation(this, operator);
    // }
    // switch operator-> add, mul, div

    Var sub(Var other);

    Var add(Scalar other);

    Var add(Vector other);

    Var add(Matrix other);

    Var mul(Scalar other);

    Var mul(Vector other);

    Var mul(Matrix other);

    Var div(Scalar other);

    Var div(Vector other);

    Var div(Matrix other);


}