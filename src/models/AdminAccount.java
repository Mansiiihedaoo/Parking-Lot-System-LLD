package models;

import Interface.Account;
import Interface.ParkingSpot;
import Constants.AccountStatus;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdminAccount extends Account {
    private final Lock adminLock = new ReentrantLock();

    public boolean addParkingSpot(ParkingSpot spot) {
        adminLock.lock();
        try {
            // Thread-safe addition of parking spot
            return true;
        } finally {
            adminLock.unlock();
        }
    }

    public boolean addEntrance(Entrance entry) {
        adminLock.lock();
        try {
            // Thread-safe addition of entrance
            return true;
        } finally {
            adminLock.unlock();
        }
    }

    public boolean addExit(Exit exit) {
        adminLock.lock();
        try {
            // Thread-safe addition of exit
            return true;
        } finally {
            adminLock.unlock();
        }
    }

    public boolean addDisplayBoard(DisplayBoard board) {
        adminLock.lock();
        try {
            // Thread-safe addition of display board
            return true;
        } finally {
            adminLock.unlock();
        }
    }

    @Override
    public boolean resetPassword() {
        // Add your own implementation here
        return false;
    }
}
