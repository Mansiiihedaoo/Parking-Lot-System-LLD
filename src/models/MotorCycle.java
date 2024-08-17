package models;

import Interface.ParkingSpot;

public class MotorCycle extends ParkingSpot {
    @Override
    public boolean getIsFree() {
        //add your own implementation here
        return false;
    }
}
