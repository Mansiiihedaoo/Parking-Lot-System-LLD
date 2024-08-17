package models;

import Interface.ParkingSpot;
import Interface.Vehicle;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingLotSystem {
    private static ParkingLotSystem instance = null;
    private static final Lock instanceLock = new ReentrantLock();
    private final int MAX_CAPACITY = 40000;
    private Map<String, Entrance> entrances;
    private Map<String, Exit> exits;
    private ParkingRate parkingRate;
    private Map<String, DisplayBoard> displayBoards;
    private Map<String, ParkingTicket> parkingTickets;
    private Map<String, ParkingSpot> parkingSpots;

    private ParkingLotSystem() {
        entrances = new HashMap<>();
        exits = new HashMap<>();
        displayBoards = new HashMap<>();
        parkingTickets = new HashMap<>();
        parkingSpots = new HashMap<>();
    }

    public static ParkingLotSystem getInstance() {
        instanceLock.lock();
        try {
            if (instance == null) {
                instance = new ParkingLotSystem();
            }
            return instance;
        } finally {
            instanceLock.unlock();
        }
    }

    public ParkingTicket getParkingTicket(Vehicle vehicle) {
        // Thread-safe ticket generation
        return null;
    }

    public boolean isFull() {
        // Check if parking lot is full
        return false;
    }

    public boolean addEntrance(Entrance entrance) {
        // Thread-safe addition of entrance
        return false;
    }

    public boolean addExit(Exit exit) {
        // Thread-safe addition of exit
        return false;
    }

    public void notifyDisplayBoards() {
        // Notify all display boards about the parking lot status
        for (DisplayBoard board : displayBoards.values()) {
            board.setChanged();
            board.notifyObservers();
        }
    }
}
