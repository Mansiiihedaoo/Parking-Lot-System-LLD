package models;

import Interface.Payment;

public class CashPayment extends Payment {
    @Override
    public synchronized boolean initiateTransaction() {
        // Thread-safe cash payment processing
        return true;
    }
}
