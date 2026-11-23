package parking;

import java.util.ArrayList;

public class ParkingManagement {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<ParkingSlot> slots;
    private ArrayList<ParkingRecord> records;

    private final double bikeRate = 10.0;
    private final double carRate = 20.0;

    public ParkingManagement() {
        vehicles = new ArrayList<>();
        slots = new ArrayList<>();
        records = new ArrayList<>();

        // Create 5 bike slots
        for (int i = 1; i <= 5; i++) {
            slots.add(new ParkingSlot(i, "Bike"));
        }

        // Create 5 car slots
        for (int i = 6; i <= 10; i++) {
            slots.add(new ParkingSlot(i, "Car"));
        }
    }
    public void addVehicle(String number, String owner, String type) {
        number = number.trim().toUpperCase();
        owner = owner.trim();
        type = type.trim();

        if (number.isEmpty() || owner.isEmpty() || type.isEmpty()) {
            System.out.println("All fields are required!");
            return;
        }

        for (Vehicle v : vehicles) {
            if (v.getVehicleNumber().equalsIgnoreCase(number)) {
                System.out.println("Vehicle already registered!");
                return;
            }
        }

        if (!type.equalsIgnoreCase("Bike") && !type.equalsIgnoreCase("Car")) {
            System.out.println("Vehicle type must be Bike or Car.");
            return;
        }
        type = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();

        vehicles.add(new Vehicle(number, owner, type));
        System.out.println("Vehicle registered successfully!");
    }
    
    public void viewVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles registered.");
            return;
        }

        System.out.println("\n--- Registered Vehicles ---");

        for (Vehicle v : vehicles) {
            v.displayVehicle();
            System.out.println("-------------------------");
        }
    }
    
    public Vehicle searchVehicle(String number) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleNumber().equalsIgnoreCase(number.trim())) {
                return v;
            }
        }

        return null;
    }

    public void searchVehicleDetails(String number) {
        Vehicle v = searchVehicle(number);

        if (v == null) {
            System.out.println("Vehicle not found.");
        } else {
            System.out.println("\nVehicle found:");
            v.displayVehicle();
        }
    }
    
    public void updateVehicle(String number, String newOwner, String newType) {
        Vehicle v = searchVehicle(number);

        if (v == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        newOwner = newOwner.trim();
        newType = newType.trim();

        if (newOwner.isEmpty()) {
            System.out.println("Owner name cannot be empty.");
            return;
        }

        if (!newType.equalsIgnoreCase("Bike") && !newType.equalsIgnoreCase("Car")) {
            System.out.println("Vehicle type must be Bike or Car.");
            return;
        }

        // Prevent changing type while the vehicle is parked
        for (ParkingRecord r : records) {
            if (r.getVehicle() == v && r.getExitTime() == null) {
                System.out.println("Cannot update a vehicle while it is parked.");
                return;
            }
        }

        v.setOwnerName(newOwner);
        v.setVehicleType(newType.substring(0, 1).toUpperCase() + newType.substring(1).toLowerCase());

        System.out.println("Vehicle details updated successfully!");
    }
    
    public void deleteVehicle(String number) {
        Vehicle v = searchVehicle(number);

        if (v == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        // Prevent deleting a currently parked vehicle
        for (ParkingRecord r : records) {
            if (r.getVehicle() == v && r.getExitTime() == null) {
                System.out.println("Cannot delete a vehicle while it is parked.");
                return;
            }
        }

        vehicles.remove(v);
        System.out.println("Vehicle deleted successfully!");
    }
    
    public void viewSlots() {
        System.out.println("\n--- Parking Slot Details ---");

        for (ParkingSlot s : slots) {
            s.displaySlot();
            System.out.println("-------------------------");
        }
    }
    
    public void viewAvailableSlots() {
        boolean found = false;

        System.out.println("\n--- Available Parking Slots ---");

        for (ParkingSlot s : slots) {
            if (!s.isOccupied()) {
                s.displaySlot();
                System.out.println("-------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No slots are currently available.");
        }
    }
    
    public ParkingSlot searchSlot(int id) {
        for (ParkingSlot s : slots) {
            if (s.getSlotId() == id) {
                return s;
            }
        }

        return null;
    }

    public void searchSlotDetails(int id) {
        ParkingSlot s = searchSlot(id);

        if (s == null) {
            System.out.println("Parking slot not found.");
        } else {
            System.out.println("\nSlot found:");
            s.displaySlot();
        }
    }
    
    public void addSlot(int id, String type) {
        type = type.trim();

        if (id <= 0) {
            System.out.println("Slot ID must be a positive number.");
            return;
        }

        if (!type.equalsIgnoreCase("Bike") && !type.equalsIgnoreCase("Car")) {
            System.out.println("Slot type must be Bike or Car.");
            return;
        }
        type = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();

        if (searchSlot(id) != null) {
            System.out.println("Slot ID already exists.");
            return;
        }

        slots.add(new ParkingSlot(id, type));
        System.out.println("Parking slot added successfully!");
    }
    
    public void updateSlot(int id, String newType) {
        ParkingSlot s = searchSlot(id);

        if (s == null) {
            System.out.println("Parking slot not found.");
            return;
        }

        newType = newType.trim();

        if (s.isOccupied()) {
            System.out.println("Cannot update an occupied slot.");
            return;
        }

        if (!newType.equalsIgnoreCase("Bike") && !newType.equalsIgnoreCase("Car")) {
            System.out.println("Slot type must be Bike or Car.");
            return;
        }
        newType = newType.substring(0, 1).toUpperCase() + newType.substring(1).toLowerCase();

        s.setSlotType(newType);
        System.out.println("Parking slot updated successfully!");
    }
    
    public void deleteSlot(int id) {
        ParkingSlot s = searchSlot(id);

        if (s == null) {
            System.out.println("Parking slot not found.");
            return;
        }

        if (s.isOccupied()) {
            System.out.println("Cannot delete an occupied slot.");
            return;
        }
        
        for (ParkingRecord r : records) {
            if (r.getSlot().getSlotId() == id) {
                System.out.println("Cannot delete a slot with parking history.");
                return;
            }
        }

        slots.remove(s);
        System.out.println("Parking slot deleted successfully!");
    }
    
    public void vehicleEntry(String number) {

        Vehicle v = searchVehicle(number);

        if (v == null) {
            System.out.println("Vehicle is not registered!");
            return;
        }

        for (ParkingRecord r : records) {
            if (r.getVehicle() == v && r.getExitTime() == null) {
                System.out.println("Vehicle is already parked!");
                return;
            }
        }

        for (ParkingSlot s : slots) {
            if (!s.isOccupied() &&
                s.getSlotType().equalsIgnoreCase(v.getVehicleType())) {

                s.setOccupied(true);
                ParkingRecord record = new ParkingRecord(v, s);
                records.add(record);

                System.out.println("Vehicle parked successfully!");
                System.out.println("Allocated Slot ID: " + s.getSlotId());
                System.out.println("Entry Time: " + record.getEntryTime());
                return;
            }
        }

        System.out.println("No suitable parking slot available!");
    }
    
    public void vehicleExit(String number) {

        Vehicle v = searchVehicle(number);

        if (v == null) {
            System.out.println("Vehicle is not registered!");
            return;
        }

        for (ParkingRecord r : records) {

            if (r.getVehicle() == v && r.getExitTime() == null) {

                double rate;

                if (v.getVehicleType().equalsIgnoreCase("Bike")) {
                    rate = bikeRate;
                } else {
                    rate = carRate;
                }

                r.completeParking(rate);

                r.getSlot().setOccupied(false);

                System.out.println("Vehicle exited successfully!");
                System.out.println("Vehicle Number: " + number);
                System.out.println("Parking Fee: Rs. " + r.getParkingFee());

                return;
            }
        }

        System.out.println("This vehicle is not currently parked!");
    }
    
    public void viewParkingHistory() {

        if (records.isEmpty()) {
            System.out.println("No parking history available.");
            return;
        }

        System.out.println("\n--- Parking History ---");

        for (ParkingRecord r : records) {
            r.displayRecord();
        }
    }

}