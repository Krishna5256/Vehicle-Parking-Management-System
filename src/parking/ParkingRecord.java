package parking;

import java.time.LocalDateTime;
import java.time.Duration;

public class ParkingRecord {
    private Vehicle vehicle;
    private ParkingSlot slot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double parkingFee;

    public ParkingRecord(Vehicle vehicle, ParkingSlot slot) {
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
        this.exitTime = null;
        this.parkingFee = 0.0;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void completeParking(double ratePerHour) {
        exitTime = LocalDateTime.now();

        long seconds = Duration.between(entryTime, exitTime).toSeconds();
        long hours = (long) Math.ceil(seconds / 3600.0);

        if (hours == 0) {
            hours = 1;
        }

        parkingFee = hours * ratePerHour;
    }

    public void displayRecord() {
        System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
        System.out.println("Slot ID: " + slot.getSlotId());
        System.out.println("Entry Time: " + entryTime);
        System.out.println("Exit Time: " + (exitTime == null ? "Not Exited" : exitTime));
        System.out.println("Parking Fee: Rs. " + parkingFee);
        System.out.println("--------------------------------");
    }
}
