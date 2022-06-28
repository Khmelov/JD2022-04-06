package by.it.arsenihlaz.jd01_08.oop;

public class RunnerShip {
    public static void main(String[] args) {
        Battleship colorado = new Battleship();
        Enemy_Ship enemy = new Enemy_Ship();
        Aircraft_Carrier langley = new Aircraft_Carrier();
        colorado.shoot(1,1);
        langley.shoot(1,2);
       enemy.getCoordinates();
       langley.buzz();
       
    }
}
