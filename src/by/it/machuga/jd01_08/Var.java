package by.it.machuga.jd01_08;

abstract class Var implements Operation {
    @Override
    public Var add(Var other) {
        System.out.println("Cannot add "+this+" and "+other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Cannot subtract "+this+" and "+other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Cannot multiply "+this+" and "+other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Cannot divide "+this+" by "+other);
        return null;
    }

    @Override
    public String toString() {
        return "unknown variable (abstract stub)";
    }
}
