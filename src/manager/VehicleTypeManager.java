package manager;

import data.ParkingSpot;

import java.util.List;

public interface VehicleTypeManager {

    List<ParkingSpot> getParkingSpots();
    double getParkingFee(double durationInHour);
}
