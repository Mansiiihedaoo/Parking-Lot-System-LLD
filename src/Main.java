//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import models.*;
import Interface.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        // Initialize the ParkingLotSystem
        ParkingLotSystem parkingLotSystem = ParkingLotSystem.getInstance();

        // Create parking spots
        ParkingSpot compactSpot = new Compact();
        ParkingSpot handicappedSpot = new Handicapped();
        ParkingSpot largeSpot = new Large();
        ParkingSpot motorcycleSpot = new MotorCycle();

        // Create display boards
        DisplayBoard displayBoard = new DisplayBoard(1);
        displayBoard.addParkingSlot("Compact", List.of(compactSpot));
        displayBoard.addParkingSlot("Handicapped", List.of(handicappedSpot));
        displayBoard.addParkingSlot("Large", List.of(largeSpot));
        displayBoard.addParkingSlot("Motorcycle", List.of(motorcycleSpot));

        // Create accounts
        AdminAccount adminAccount = new AdminAccount();
        adminAccount.addParkingSpot(compactSpot);
        adminAccount.addDisplayBoard(displayBoard);

        AgentAccount agentAccount = new AgentAccount();

        // Create vehicles and tickets
        Vehicle car = new Car();
        Vehicle motorcycle = new MotorCycleVehicle();
        ParkingTicket carTicket = parkingLotSystem.getParkingTicket(car);
        ParkingTicket motorcycleTicket = parkingLotSystem.getParkingTicket(motorcycle);

        // Process tickets
        boolean carProcessed = agentAccount.processTicket(carTicket);
        boolean motorcycleProcessed = agentAccount.processTicket(motorcycleTicket);

        // Check and notify parking lot status
        if (parkingLotSystem.isFull()) {
            displayBoard.sendParkingFullNotification();
        }
        displayBoard.showFree();

        // Simulate payments
        Payment cardPayment = new CardPayment();
        Payment cashPayment = new CashPayment();
        cardPayment.initiateTransaction();
        cashPayment.initiateTransaction();

        // Output results
        System.out.println("Car Ticket Processed: " + carProcessed);
        System.out.println("Motorcycle Ticket Processed: " + motorcycleProcessed);
        System.out.println("Parking Lot Full: " + parkingLotSystem.isFull());
    }
}