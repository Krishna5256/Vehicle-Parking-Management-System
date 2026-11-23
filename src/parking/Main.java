package parking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParkingManagement pm = new ParkingManagement();

        int choice = 0;

        do {
            System.out.println("\n==================================");
            System.out.println(" VEHICLE PARKING MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Register Vehicle");
            System.out.println("2. View Registered Vehicles");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Update Vehicle");
            System.out.println("5. Delete Vehicle");
            System.out.println("6. View All Parking Slots");
            System.out.println("7. View Available Slots");
            System.out.println("8. Search Parking Slot");
            System.out.println("9. Add Parking Slot");
            System.out.println("10. Update Parking Slot");
            System.out.println("11. Delete Parking Slot");
            System.out.println("12. Vehicle Entry");
            System.out.println("13. Vehicle Exit");
            System.out.println("14. View Parking History");
            System.out.println("15. Exit");
            System.out.print("Enter your choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {

            case 1:
                System.out.print("Enter Vehicle Number: ");
                String number = sc.nextLine();

                System.out.print("Enter Owner Name: ");
                String owner = sc.nextLine();

                System.out.print("Enter Vehicle Type (Bike/Car): ");
                String type = sc.nextLine();

                pm.addVehicle(number, owner, type);
                break;

            case 2:
                pm.viewVehicles();
                break;

            case 3:
                System.out.print("Enter Vehicle Number: ");
                pm.searchVehicleDetails(sc.nextLine());
                break;

            case 4:
                System.out.print("Enter Vehicle Number: ");
                number = sc.nextLine();

                System.out.print("Enter New Owner Name: ");
                owner = sc.nextLine();

                System.out.print("Enter New Vehicle Type (Bike/Car): ");
                type = sc.nextLine();

                pm.updateVehicle(number, owner, type);
                break;

            case 5:
                System.out.print("Enter Vehicle Number: ");
                pm.deleteVehicle(sc.nextLine());
                break;

            case 6:
                pm.viewSlots();
                break;

            case 7:
                pm.viewAvailableSlots();
                break;

            case 8:
                System.out.print("Enter Slot ID: ");

                if (sc.hasNextInt()) {
                    int slotId = sc.nextInt();
                    sc.nextLine();
                    pm.searchSlotDetails(slotId);
                } else {
                    System.out.println("Invalid Slot ID! Please enter a number.");
                    sc.nextLine();
                }
                break;

            case 9:
                System.out.print("Enter New Slot ID: ");

                if (sc.hasNextInt()) {
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Slot Type (Bike/Car): ");
                    type = sc.nextLine();

                    pm.addSlot(id, type);
                } else {
                    System.out.println("Invalid Slot ID! Please enter a number.");
                    sc.nextLine();
                }
                break;

            case 10:
                System.out.print("Enter Slot ID: ");

                if (sc.hasNextInt()) {
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Slot Type (Bike/Car): ");
                    type = sc.nextLine();

                    pm.updateSlot(id, type);
                } else {
                    System.out.println("Invalid Slot ID! Please enter a number.");
                    sc.nextLine();
                }
                break;

            case 11:
                System.out.print("Enter Slot ID: ");

                if (sc.hasNextInt()) {
                    int id = sc.nextInt();
                    sc.nextLine();

                    pm.deleteSlot(id);
                } else {
                    System.out.println("Invalid Slot ID! Please enter a number.");
                    sc.nextLine();
                }
                break;

            case 12:
                System.out.print("Enter Vehicle Number: ");
                pm.vehicleEntry(sc.nextLine());
                break;

            case 13:
                System.out.print("Enter Vehicle Number: ");
                pm.vehicleExit(sc.nextLine());
                break;

            case 14:
                pm.viewParkingHistory();
                break;

            case 15:
                System.out.println("Thank you for using the system!");
                break;

            default:
                System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 15);

        sc.close();
    }
}
