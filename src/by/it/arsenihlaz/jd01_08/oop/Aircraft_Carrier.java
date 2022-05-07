package by.it.arsenihlaz.jd01_08.oop;

public class Aircraft_Carrier extends Warship{
    @Override
    public void sail(double speed) {
        System.out.println("aircraft carrier sailing at speed" + speed);
    }
    public void buzz() {
        System.out.println("the aircraft carrier is buzzing gooo-gooo");
    }

    @Override
    boolean shoot(int x, int y) {
        System.out.println("planes took off");
        if (x == Enemy_Ship.coordinates[0] && y == Enemy_Ship.coordinates[1]) {
            System.out.println("bombs dropped successfully");
            return true;
        } else {
            System.out.println("missed");
            return false;
        }
    }
}
