package parking;

public class ParkingSlot {
    private int slotId;
    private String slotType;
    private boolean occupied;

    public ParkingSlot(int slotId, String slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.occupied = false;
    }

    public int getSlotId() {
        return slotId;
    }

    public String getSlotType() {
        return slotType;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
    
    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public void displaySlot() {
        System.out.println("Slot ID: " + slotId);
        System.out.println("Slot Type: " + slotType);
        System.out.println("Status: " + (occupied ? "Occupied" : "Available"));
    }
}