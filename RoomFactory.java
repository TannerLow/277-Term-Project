/**
 * Creates rooms of specified types
 */
public class RoomFactory {
	/**
	 * Creates a RoomFactory
	 */
	public RoomFactory() {}
	
	/**
	 * Returns a room of specified type
	 * 
	 * @param type The type of room (regular, deluxe, suite)
	 */
	public Room getRoom(String type) {
		type = type.toLowerCase();
		if(type.equals("regular")) {
			return new RegularRoom();
		}
		else if(type.equals("deluxe")) {
			return new DeluxeRoom();
		}
		else if(type.equals("suite")) {
			return new SuiteRoom();
		}
		return null;
	}
	
	/**
	 * Creates a a room of type type and decorates it with amenities.
	 * @param type the type of room you wish to make (regular, deluxe, suite)
	 * @param amenities a string array of amenities to add to the room
	 * @return the Room that was made
	 */
	public Room getRoom(String type, String[] amenities) {
		Room r = null;
		type = type.toLowerCase();
		//Create room type
		if(type.equals("regular")) {
			r = new RegularRoom();
		}
		else if(type.equals("deluxe")) {
			r = new DeluxeRoom();
		}
		else if(type.equals("suite")) {
			r = new SuiteRoom();
		}
		else{
			return null;
		}
		
		//add amenities
		for(String amenity : amenities) {
			switch(amenity.toLowerCase()) {
				case "spa"			: r = new Spa(r);		break;
				case "foodbar"		: r = new FoodBar(r);	break;
				case "shower"		: r = new Shower(r);	break;
				case "autorefill"	: r = new AutoRefill(r);break;
				default : break;
			}
		}
		return r;
	}
	
	/**
	 * Returns a String representation of this RoomFactory
	 * @return A String representation of this RoomFactory
	 */
	public String toString()
	{
		return "This is a Factory that creates Rooms";
	}
}
