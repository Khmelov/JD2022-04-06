package by.it.marchenko.calc;

interface Operation {
    Var add(Var other);
    Var add(Scalar other);
    Var add(Vector other);
    Var add(Matrix other);

    Var sub(Var other);

    Var mul(Var other);
    Var mul(Scalar other);
    Var mul(Vector other);
    Var mul(Matrix other);


    Var div(Var other);

 //   Var operation(String operator, Var operand);
}