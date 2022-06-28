package by.it._examples_.jd02_06.p07_facade.facade;

// фасад для работы 

import by.it._examples_.jd02_06.p07_facade.parts.Clamping;
import by.it._examples_.jd02_06.p07_facade.parts.Door;
import by.it._examples_.jd02_06.p07_facade.parts.Wheel;

public class CarFacade {

    private final Door door = new Door();
    private final Clamping clamping = new Clamping();
    private final Wheel wheel = new Wheel();

    public void go(){
        door.open();
        clamping.fire();
        wheel.turn();
    }
    
        
    
}
