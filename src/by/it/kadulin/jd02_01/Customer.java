package by.it.kadulin.jd02_01;

public class Customer {
    private final String name;
    private double mltSpeedOperation = 1;
    private int countWTB;

    public void setCountWTB(int countWTB) {
        this.countWTB = countWTB;
    }

    public int getCountWTB() {
        return countWTB;
    }

    public double getMltSpeedOperation() {
        return mltSpeedOperation;
    }

    public void setMltSpeedOperation(double mlt) {
        mltSpeedOperation = mlt;
    }

    public Customer(long number) {
        this.name = "Customer #" + number;
        setCountWTB(RandomGenerator.get(2, 5));
    }

    @Override
    public String toString() {
        return name;
    }
}
