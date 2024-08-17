package models;

import Interface.Payment;

public class CardPayment extends Payment {
    @Override
    public synchronized boolean initiateTransaction() {
        // Thread-safe card payment processing
        return true;
    }
}
