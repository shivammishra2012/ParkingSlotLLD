package parkingSpotSelector;

import data.ParkingSpot;

import java.util.List;

public interface ParkingSpotSelector {
    ParkingSpot selectSpot(List<ParkingSpot> parkingSpots);

}
