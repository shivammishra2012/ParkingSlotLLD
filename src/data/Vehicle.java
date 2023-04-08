package data;

import java.time.LocalDateTime;

public class Vehicle {


    public String getName() {
        return name;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public VehicleType getEntryTime() {
        return entryTime;
    }

    private final String name;
    private final VehicleType vehicleType;

    private final String number ;
    private final LocalDateTime entryTime;
    public Vehicle(String name, VehicleType vehicleType, String number, LocalDateTime entryTime) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.number = number;
        this.entryTime = entryTime;
    }



}
