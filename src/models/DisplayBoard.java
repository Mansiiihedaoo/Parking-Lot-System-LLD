package models;

import Interface.ParkingSpot;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DisplayBoard extends Observable implements Observer {
    private int id;
    private final Lock boardLock = new ReentrantLock();
    private Map<String, List<ParkingSpot>> parkingSpots;

    public DisplayBoard(int id) {
        this.id = id;
        parkingSpots = new HashMap<>();
    }

    public void showFree() {
        // Thread-safe display of free spots
    }

    public void sendParkingFullNotification() {
        // Notify that the parking lot is full
    }

    public void addParkingSlot(String spotType, List<ParkingSpot> spots) {
        boardLock.lock();
        try {
            parkingSpots.put(spotType, spots);
        } finally {
            boardLock.unlock();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        // Update display board based on the observable's state
        showFree();
    }
}
