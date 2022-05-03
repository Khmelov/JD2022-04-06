package by.it.arsenihlaz.jd01_08.oop;

public class Aircraft_Carrier extends Warship{
    @Override
    public void sail(double speed) {
        System.out.println("aircraft carrier sailing at speed" + speed);
    }
    public void buzz() {
        System.out.println("the aircraft carrier is buzzing gooo-gooo");
    }
}
