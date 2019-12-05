/**
 * Amenities decorate rooms.
 */
public abstract class Amenity extends Room
{
	/**
	 * Returns the description of the Room and its Amenities.
	 * @return The description of the Room and its Amenities.
	 */
	public abstract String getDescription();
	
	/**
	 * Returns a String representation of the Room and its Amenities
	 * @return A String representation of the Room and its Amenities
	 */
	public String toString()
	{
		return getDescription();
	}
}
