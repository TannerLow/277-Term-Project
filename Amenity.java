/**
 * Amenities decorate rooms.
 */
public abstract class Amenity extends Room
{
	protected Room type;
	/**
	 * Returns the description of the Room and its Amenities.
	 * @return The description of the Room and its Amenities.
	 */
	public abstract String getDescription();
	
	/**
	 * Sets the do not disturb flag 
	 * @param dnd the flag value to set
	 */
	public void setDoNotDisturb( boolean dnd)
	{
		type.setDoNotDisturb(dnd);
	}
	/**
	 * gets the do not disturb flag
	 */
	public boolean getDoNotDisturb()
	{
		return type.getDoNotDisturb();
	}
}