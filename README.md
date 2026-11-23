# Vehicle Parking and Slot Allocation Management System

A Java console-based application developed to manage vehicle registration, parking slot allocation, vehicle entry and exit, and parking fee calculation.

## Features

- Register, view, search, update, and delete vehicles.
- Add, view, search, update, and delete parking slots.
- Automatically allocate parking slots based on vehicle type (Bike or Car).
- Manage vehicle entry and exit.
- Calculate parking fees based on parking duration.
- View parking history with entry time, exit time, and parking fee.
- Validate user inputs and prevent duplicate vehicle registration.
- Prevent deletion of occupied parking slots and vehicles currently parked.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- Scanner
- LocalDateTime
- Duration

## Parking Fee

| Vehicle Type | Fee per Hour |
|---|---:|
| Bike | ₹10 |
| Car | ₹20 |

The fee is calculated based on the parking duration, rounded up to the next hour, with a minimum charge of one hour.

## Project Structure

```text
Vehicle-Parking-Management-System/
└── src/
    └── parking/
        ├── Main.java
        ├── Vehicle.java
        ├── ParkingSlot.java
        ├── ParkingRecord.java
        └── ParkingManagement.java
```

## Class Description

- **Main.java:** Displays the menu and handles user input.
- **Vehicle.java:** Stores vehicle details.
- **ParkingSlot.java:** Manages parking slot information and availability.
- **ParkingRecord.java:** Stores parking entry, exit, and fee details.
- **ParkingManagement.java:** Handles the main parking management operations.

## How to Run

1. Clone or download this repository.
2. Open Eclipse IDE.
3. Import the project into Eclipse or create a Java project and copy the `src` folder.
4. Open `Main.java`.
5. Run the program as a Java Application.

## Note

This is a console-based Java project. Data is maintained in memory using ArrayList and is reset when the application is closed.

## Author

U J Krishna

GitHub: [Krishna5256](https://github.com/Krishna5256)
