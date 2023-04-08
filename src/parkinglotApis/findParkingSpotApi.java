package parkinglotApis;

import data.EntryPoint;
import data.ParkingSpot;
import data.VehicleType;
import data.SpotSelection;
import manager.VehicleTypeManager;
import manager.VehicleTypeManagerFactory;
import parkingSpotSelector.ParkingSpotFinder;
import parkingSpotSelector.ParkingSpotSelector;
import parkingSpotSelector.SpotSelectorFactory;

public class findParkingSpotApi {


    public ParkingSpot findParkingSpot(EntryPoint entryPoint, VehicleType vehicleType, SpotSelection spotselection)
    {

        // i need to invoke  differnent manager based on vehicletype so factory pattern is best for this use case in order to keep
        VehicleTypeManager vehicleTypeManager= VehicleTypeManagerFactory.getVehicleTypeManager(vehicleType);
        ParkingSpotSelector parkingSpotSelector;
        if(spotselection.equals(SpotSelection.RANDOM))
        {
            parkingSpotSelector= SpotSelectorFactory.getRandomSelector();
        }
        else if(spotselection.equals(SpotSelection.NEAREST))
        {
            parkingSpotSelector= SpotSelectorFactory.getNearestParkingSpotSelector(entryPoint);
        }
        else {
            throw new RuntimeException("");
        }
        return new ParkingSpotFinder(vehicleTypeManager,parkingSpotSelector).findParkingSpot();

    }


}
