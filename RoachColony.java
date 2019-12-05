/**
 * RoachColony can register to a waitlist.
 */

public class RoachColony implements WObserver
{
	private String name;
	private int population;
	private double growthRate;
	private boolean party;

	/**
	 * Creates a "default" RoachColony
	 */
	public RoachColony()
	{
		name = "no_name";
		population = -1;
		growthRate = 0;
		party = false;
	}

	/**
	 * Creates a RoachColony with a name, population, and growth rate
	 * 
	 * @param name       The name of the colony
	 * @param population The population of the colony
	 * @param growthRate The growth rate of the colony
	 */
	public RoachColony(String name, int population, double growthRate)
	{
		this.name = name;
		this.population = population;
		this.growthRate = growthRate;
		party = false;
	}

	/**
	 * Increases the population of the RoachColony, based on their growth rate.
	 */
	public void party()
	{
		population *= growthRate;
		party = true;
	}
	
	public boolean spray(boolean hasShower) {
		if(party) {
			if(hasShower) {
				population *= 0.75;
			}
			else {
				population *= 0.5;
			}
			party = false;
			return true;
		}
		return false;
	}

	/**
	 * Returns a String representation of the RoachColony
	 * 
	 * @return A String representation of the RoachColony
	 */
	public String toString()
	{
		return "Colony - Name: " + name + "; Pop.: " + population + "; Rate: " + growthRate;
	}

	/**
	 * Updates the colony on anything it is observing
	 * 
	 * @param newState New state of Object being observered
	 */
	public void update(Object newState)
	{
		System.out.println("[To:" + name + "]:" + newState);
	}
}
