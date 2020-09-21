public class Colony {
	/**
	 * A Colony object consists of multiple houses.
	 */

	 //Represents the colony name
	private String colonyName;

	// Represents the maximum number of Houses in a colony.
	private static final int MAX_HOUSES = 10;

	// Represents the number of houses in the colony.
	private int noOfHouses;

	//Represents an array containing objects of house class.
	private House[] quarters;

	/**
	 * Constructor for Colony Class.
	 * 
	 * @param Name sets the colony name
	 */
	public Colony(String Name) {
		this.colonyName = Name;
		this.quarters = new House[MAX_HOUSES];
	}

	/**
	 * Getter method for the colony name
	 */
	public String getColonyName() {

		return this.colonyName;
	}

	/**
	 * Adds a house to a colony
	 * @param h house to be added
	 * @return true if house can be added else false
	 */
	public boolean addHouse(House h) {

		if(noOfHouses < MAX_HOUSES){
			quarters[noOfHouses] = h;
			noOfHouses = noOfHouses + 1;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Calculates the total maintenance cost recovered by the admin
	 * @return the total maintenance cost of the colony
	 */
	public int getTotalMaintenanceCost() {

		int totalMaintenanceCost = 0;
		for(int i = 0; i < noOfHouses; i++) {
			totalMaintenanceCost += quarters[i].getMaintenanceCost();
		}

		return totalMaintenanceCost;
	}
}