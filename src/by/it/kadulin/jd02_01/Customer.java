package by.it.kadulin.jd02_01;

public class Customer {
    private final String name;
    private double mltSpeedOperation = 1;

    public double getMltSpeedOperation() {
        return mltSpeedOperation;
    }

    public void setMltSpeedOperation(double mlt) {
        mltSpeedOperation = mlt;
    }

    public Customer(long number) {
        this.name = "Customer #" + number;
    }

    @Override
    public String toString() {
        return name;
    }
}
