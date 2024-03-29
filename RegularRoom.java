/**
 * RegularRoom is a concrete implementation of abstract Room.
 */
public class RegularRoom extends Room
{

	public static final int COST = 50;

	/**
	 * Creates a RegularRoom.
	 */
	public RegularRoom()
	{
		description = "Regular Room";
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
