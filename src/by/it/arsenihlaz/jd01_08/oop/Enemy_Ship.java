package by.it.arsenihlaz.jd01_08.oop;

import java.util.Arrays;

public class Enemy_Ship extends Warship implements Ship{

    @Override
    public void sail(double speed) {

    }

    @Override
    public void buzz() {

    }
    public static int[] getCoordinates(){
        int[] coordinatesEnemy = new int[2];
        for (int i = 0; i < coordinatesEnemy.length; i++) {
            coordinatesEnemy[i] = (int) (Math.random()*5);
        }
        System.out.println(Arrays.toString(coordinatesEnemy));
        return coordinatesEnemy;
    }

}
