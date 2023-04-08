# ParkingSlotLLD


Search by videos or problems


Switch Learning Path
Shivam kumar

Design Parking Lot
1. Let’s design a Parking Lot system which can tell users about the Free Spots for Parking any vehicle. It will also manage the other important things like generating the tickets and collecting the money etc.

2. Let’s look into some basic requirements our system needs to have.

It should be able to find out the free parking spot for vehicles.

It should be able to handle different categories of vehicles like 2-wheelers , 4-wheelers , heavy vehicles like trucks etc . All different categories will have different fee structures.

It should have multiple floors and multiple entry and exit points.

Whenever any vehicle takes entry via any gate it should be given a valid ticket and at the time exiting via any gate. Vehicle must show the ticket and then the system should tell the vehicle about the amount to be paid.

It should charge the vehicles on hourly basis.

It should support different payment methods like Cash and Card Based Payments.

3. Let’s take a look for some important APIs that will be needed in our System

A. FindParkingSpotAPI : This API will help in finding the right spot for the vehicle to park. This will take Entry point, vehicle Type and Spot Selection Strategy as Input and provide Parking Spot as Output.

B. GetTicketAPI : this will generate the Ticket for the vehicle , it will take the vehicle as input and give the ticket as output.

C. PayParkingFeesAPI : it will take Ticket Payment Details as input and OutPut the status of the payment as SUCCESS / FAIL.

D. VacateParkingSpotAPI : it will vacate the parking spot. it will take the parking spot as input and SUCCESS / FAIL as Output.

4. Let’s create some important classes we need to structure our system.

5. First class is FindParkingSpotAPI which will contain a public function

public ParkingSpot findParkingSpot(EntryPoint entryPoint , VehicleType vehicleType, SpotSelection spotSelection) ,

Where  ParkingSpot , EntryPoint , VehicleType , SpotSelection are the data classes and Enum.

6. We are using data classes instead of Enums as EntryPoint because Keeping Entry Point as an Enum will require us to make modifications  to that enum whenever a new Entry gate is built or old gates are closed for some reason.

7. Better idea is to keep it as a data class and the attributes of that data class like gate number can be stored and read from the database. This way we would just need data entry into our database whenever modifications are made. Hence application code would remain unchanged.

8. Another class we create is EntryPoint which will contain two attributes

Private final String name;

Private final boolean isOpen;

It will also contain constructor and getters.

9. We can use Enum for VehicleType with three types in it .

TWO_WHEELER

FOUR_WHEELER

HEAVY

10. Another ENUM we create is SpotSelection with 2 types in it.

RANDOM,

NEAREST




11. To manage the vehicle types , there must be an interface VehicleTypeManager. It will contain two methods

List<ParkingSpot > getParkingSpots();

double getParkingFees(double durationInHours) ;

12. Now we can simple make it implement our vehicle types 

Example : public class TwoWheelManager implements  VehicleTypeManager 

{

}

And these classes will have the same methods as our interface.

13. Similarly we can create FourWheelManager and HeavyVehicleManager.

14.                                      




15. Since we have created different Vehicle Types Manager. we need to create an instance of each of them. To do the same we need to set up a factory for that.

16. We need to have a VehicleTypeManagerFactory which will contain a private constructor and a public method getVehicleTypeManager of return type vehicleTypeManager and takes VehicleType vehicleType as input and using some if-else condition it will return us the VehicleTypeManager.

17. Next we need to work on our Spot Selection. We have multiple spots available but we need to find the best spot for our vehicle.

18. It is very similar to our VehicleType, we need to have a spotSelection method which will take a list of all the parking spots available , apply some logic and return us the best parking Spot as per the need.

19. Since there can be different Spot selection strategies i.e. RandomSelection, NearestSelection etc hence it is best to create an interface for ParkingSpotSelector.

20. Our interface ParkingSpotSelector will have a single method selectSpot which will take a List of parking spots and return a ParkingSpot.

21. Now we can create a concrete implementation class of this interface i.e. NearestSelector and RandomSelector 

  




22. Difference between our strategies is that our nearest selection strategy will depend upon the entry point whereas random selection strategy does not.

23. Since we have different strategies we need to create instances of these classes. Hence we need to have a Factory for  that i.e.SpotSelectorFactory.

24. Our factory will contain a private constructor , and two public static methods

Public static ParkingSpotSelector getNearestParkingSpotSelector(EntryPoint entryPoint)

{}

Public static ParkingSpotSelector getRandomSelector()

{}

Here we can see that our getNearestParkingSpotSelector(EntryPoint entryPoint) needs a Parameter for creating an instance whereas ParkingSpotSelector does not  need any parameter .

25. Write some Business Logic for FindParkingSpotAPI class

26. Let’s create a class ParkingSpotFinder class in accordance with strategy patterns.

27. This class will contain two attributes

Private final VehicleTypeManager vehicleTypeManager ;

Private final ParkingSpotSelector parkingSpotSelector ;

And a public constructor and a public method

Public ParkingSpot  findParkingSpot()

{}

28. Moving onto our next API class which is GetTicketAPI. It will contain a public method

Public Ticket getTicket(Vehicle , vehicle , ParkingSpot parkingSpot )

{}

Where Vehicle and ParkingSpot are the data classes.

29. Create a data class Vehicle which will contain the following attributes

Private final String name ;

Private final VehicleType vehicleType  ;

Private final String number ;

Private final LocalDateTime entryTime ;

And a constructor and getters for them.

30. Similarly create ParkingSpot class which will contain following attributes

Private final String floorNum;

Private final VehicleType vehicleType;

Private final String name;

Private final boolean isFree;

And a constructor and getters for them.

31. Same goes for class Ticket with following attributes

Private final String refNum;

Private final Vehicle Vehicle ;

Private final ParkingSpot parkingSpot;

And a constructor and getters for them

32. All the necessary data classes have been created now for our GetTicketAPI class. We need to have an underline class which will have Algorithm to generate tickets.

33. For that we need to create a TicketGenerator Class. This will contain a public method generateTicket which will return a Ticket after generating it .

34. generateTicket will need to call another method of same class which will be private i.e. getUniqueTicketNum()
