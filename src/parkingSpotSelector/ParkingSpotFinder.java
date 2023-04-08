package parkingSpotSelector;

import data.ParkingSpot;
import manager.VehicleTypeManager;

import java.util.List;

public class ParkingSpotFinder {

    private final VehicleTypeManager vehicleTypeManager;
    private final ParkingSpotSelector parkingSpotSelector;

    public ParkingSpotFinder(VehicleTypeManager vehicleTypeManager, ParkingSpotSelector parkingSpotSelector) {
        this.vehicleTypeManager = vehicleTypeManager;
        this.parkingSpotSelector = parkingSpotSelector;
    }

    public ParkingSpot findParkingSpot()
    {
        // streategy design pattern
        List<ParkingSpot> parkingSpots=this.vehicleTypeManager.getParkingSpots();
        return this.parkingSpotSelector.selectSpot(parkingSpots);
    }
}
