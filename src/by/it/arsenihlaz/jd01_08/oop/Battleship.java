package by.it.arsenihlaz.jd01_08.oop;

public class Battleship extends Warship {

    public static boolean shoot(int x, int y) {
        if (x == Enemy_Ship.coordinates[0] && y == Enemy_Ship.coordinates[1]) {
            System.out.println("target hit");
            return true;
        } else {
            System.out.println("missed");
            return false;
        }
    }

    @Override
    public void sail(double speed) {
        System.out.println("aircraft carrier sailing at speed" + speed);
    }

    @Override
    public void buzz() {

    }
}
