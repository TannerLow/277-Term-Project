/**
 * SuiteRoom is a concrete implementation of abstract Room.
  * @author Tanner Lowthorp
 * @author Evan Chen
 * @author Kali
 * @author Adrian
 * @author William
 */
public class SuiteRoom extends Room
{

	public static final int COST = 100;

	/**
	 * Creates a SuiteRoom.
	 */
	public SuiteRoom()
	{
		description = "Suite Room";
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
