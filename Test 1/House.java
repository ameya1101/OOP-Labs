/**
 * A House object is a part of Colony.
 */
public class House{
	// Represents a final static int that represents the electricity charges per house member. The value is equal to 600.
	private static final int ELECTRICITY_CHARGES = 600;

	// Represents a final static int that represents the maximum number of rooms that can be there in house. The value is equal to 5.
	private static final int MAX_ROOMS = 5;

	// Represents a final static int that represents the painting rate of a room. The value is equal to 5.
	private static final int PAINTING_RATE = 5;

	//Represents a final static int that represents the tax per room floor area. The value is equal to 40.
	private static final int TAX = 40;

	// Represents a final static int that represents the water charges per house member. The value is equal to 300.
	private static final int WATER_CHARGES = 300;

	// Represents the house number.
	private int houseNumber;

	// Represents the number of people.
	private int noOfPeople;

	// Represents the number of rooms in the house.
	private int noOfRooms;

	// Represents an array containing objects of Room class.
	private Room[] rooms;

	/**
	 * Constructor for House Class.
	 * @param num 
	 * @param people 
	 */
	public House(int num, int people) {
		this.houseNumber = num;
		this.noOfPeople = people;
		this.rooms = new Room[MAX_ROOMS];
	}

	/**
	 * Adds a room object to the House.
	 * 
	 * @return true if room is added successfully else false 
	 */
	public boolean addRoom(int l,int b,int h){

		if (noOfRooms < MAX_ROOMS) {
			Room newRoom = new Room(l, b, h);
			rooms[noOfRooms] = newRoom;
			noOfRooms = noOfRooms + 1;
			return true;
		} 
		else {
			return false;
		}
	}

	/**
	 * Adds a room object to the House.
	 * @param d
	 * @return true if room is added successfully else false 
	 */
	public boolean addRoom(int d){

		return addRoom(d, d, d);
	}

	/**
	 * Calculates the total cost of painting the gouse
	 * @return the cost to paint the house
	 */
	public int getCostofPaint(){

		int totalLateralArea = 0;
		for (int i = 0; i < noOfRooms; i++) {
			totalLateralArea += rooms[i].getLateralArea();
		}
		return PAINTING_RATE*totalLateralArea;
	}
	
	/**
	 * Calculates the total maintenance cost
	 * 
	 * @return int representing the maintenance cost of the house
	 */
	public int getMaintenanceCost(){

		int totalElectricityCost = noOfPeople*ELECTRICITY_CHARGES;
		int totalWaterCost = noOfPeople*WATER_CHARGES;
		int totalPaintCharges = getCostofPaint();
		int totalTax = 0;

		for(int i = 0; i < noOfRooms; i++) {
			totalTax += TAX * rooms[i].getFloorArea();
		}

		int maintenanceCost = totalTax + totalWaterCost + totalPaintCharges + totalElectricityCost;

		if((houseNumber % 3 == 0) && (noOfPeople != 0)) {
			maintenanceCost = maintenanceCost - 100;
		}

		return maintenanceCost;
	}
}