/**
 * Rooms of different types are made in a RoomFactory. Rooms can be visited by
 * RoomVisitors. Rooms can be decorated by an Amenity.
 */
public abstract class Room
{
	protected RoachColony roomColony;
	protected String description;
	protected boolean doNotDisturb;
	protected int nights;

	/**
	 * Returns the number of nights this Room has been used
	 * @return The number of nights this Room has been used
	 */
	public int getNights()
	{
		return nights;
	}

	/**
	 * Increments the number of nights this Room has been used
	 */
	public void incNights()
	{
		nights++;
	}

	/**
	 * Returns the RoachColony using this Room
	 * @return The RoachColony using this Room
	 */
	public RoachColony getColony()
	{
		return roomColony;
	}

	/**
	 * Sets the rooms Colony to passed in colony
	 * 
	 * @param roomColony the roomColony to set
	 */
	public void setRoomColony(RoachColony roomColony)
	{
		this.roomColony = roomColony;
	}

	/**
	 * Returns the description of this Room
	 * @return The description of this Room
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Sets the DoNotDisturb sign/flag of this Room to true/false
	 * @param dnd The value of the DoNoDisturb flag to set
	 */
	public void setDoNotDisturb(boolean dnd)
	{
		doNotDisturb = dnd;
	}

	/**
	 * Returns the value of the DoNotDisturb sign/flag of this Room
	 * @return The value of the DoNotDisturb sign/flag of this Room
	 */
	public boolean getDoNotDisturb()
	{
		return doNotDisturb;
	}

	public abstract int getCost();

	// More methods will be added but this one is necessary for visitor pattern
	public abstract void accept(RoomVisitor visitor);
	
	/**
	 * Returns a String representation of this Room
	 * @return A String representation of this ROom
	 */
	public String toString()
	{
		return getDescription() + " $" +  getCost();
	}
}
