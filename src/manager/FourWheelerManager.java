package manager;

import data.ParkingSpot;

import java.util.List;


public class FourWheelerManager implements VehicleTypeManager{
    @Override
    public List<ParkingSpot> getParkingSpots() {
        return null;
    }

    @Override
    public double getParkingFee(double durationInHour) {
        return 0;
    }
}
