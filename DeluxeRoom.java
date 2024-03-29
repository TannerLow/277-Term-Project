/**
 * DeluxeRoom is a concrete implementation of abstract Room.
 */
public class DeluxeRoom extends Room
{

	public static final int COST = 75;

	/**
	 * Creates a DeluxeRoom.
	 */
	public DeluxeRoom()
	{
		description = "Deluxe Room";
	}

	/**
	 * Returns the nightly cost of the room.
	 */
	public int getCost()
	{
		return COST;
	}

	/**
	 * Accepts a RoomVisitor to this room.
	 * 
	 * @param visitor The RoomVisitor.
	 */
	public void accept(RoomVisitor visitor)
	{
		visitor.visit(this);
	}
}
