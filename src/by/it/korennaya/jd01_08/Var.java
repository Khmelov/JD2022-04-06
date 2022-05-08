package by.it.korennaya.jd01_08;

abstract class Var implements Operation{
    @Override
    public Var add(Var other) {
        System.out.printf("Incorrect operation %s+%s%n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Incorrect operation %s-%s%n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Incorrect operation %s*%s%n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Incorrect operation %s/%s%n", this, other);
        return null;
    }

}
