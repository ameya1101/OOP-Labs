/**
 * A Room object is a part of House.
 */
public class Room{
	// Represents the length of the room.
	private int length;

	// Represents the width of the room.
	private int width;
	
	// Represents the height of the room.
	private int height;

	/**
	 * Constructor for Room Class. Takes an input parameter l, w, and h and set the height to h, width to w and length to l .
	 * @param l
	 * @param w
	 * @param h
	 */
	public Room(int l, int w, int h) {
		this.length = l;
		this.width = w;
		this.height = h;
	}

	/**
	 * Constructor for Room Class. Takes an input parameter d and set the length , width and height to d .
	 * @param d
	 */
	public Room(int d) {
		this(d, d, d);
	}

	/**
	 * Returns the lateral area of the room. 
	 * @return int representing lateral area of the room.
	 */
	public int getLateralArea()	{
		int lateralArea = 2 * (this.length*this.height + this.width*this.height);
		return lateralArea;
	}

	/**
	 * Returns the floor area of the room.
	 * @return int representing floor area of the room.
	 */
	public int getFloorArea() {
		int floorArea = this.length * this.width;
		return floorArea;
	}
}