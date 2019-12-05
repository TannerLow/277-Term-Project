import java.util.ArrayList;

public class RoachMotel
{
	private static RoachMotel instance = null;
	private ArrayList<Room> rooms;
	private static final int MAX_NUMBER_OF_ROOMS = 5;
	private Waitlist wlist;
	private RoomFactory rf;
	private Maid m;
	private TransactionLog log;

	/**
	 * Creates a RoachMotel.
	 */
	private RoachMotel()
	{
		rooms = new ArrayList<Room>(MAX_NUMBER_OF_ROOMS);
		wlist = new Waitlist();
		rf = new RoomFactory();
		m = new Maid();
		log = new TransactionLog();
	}

	/**
	 * Gets the RoachMotel.
	 * 
	 * @return The singular RoachMotel.
	 */
	public static RoachMotel getInstance()
	{
		if (instance == null)
		{
			instance = new RoachMotel();
		}
		return instance;
	}

	/**
	 * Returns true if the RoachMotel has vacancy.
	 * 
	 * @return True if the RoachMotel has vacancy.
	 */
	public boolean hasVacancy()
	{
		return (rooms.size() < MAX_NUMBER_OF_ROOMS) ? true : false;
	}

	/**
	 * create a Room and Check in a colony to the room then add to the list of
	 * rooms.
	 * 
	 * @param rc
	 * @param rmtype
	 * @param amenities
	 * @return the checked-in room
	 */
	public Room checkin(RoachColony rc, String rmtype)
	{
		if (hasVacancy())
		{
			// create room and assign colony
			Room rm = rf.getRoom(rmtype);
			rm.setRoomColony(rc);
			rooms.add(rm);
			return rm;
		}
		else
		{
			System.out.println("No vacancy, colony will be moved to waitlist");
			wlist.addObserver(rc);
			return null;
		}
	}
	
	/**
	 * create a Room and Check in a colony to the room then add to the list of
	 * rooms.
	 * 
	 * @param rc
	 * @param rmtype
	 * @param amenities
	 * @return the checked-in room
	 */
	public Room checkin(RoachColony rc, String rmtype, String[] amenities)
	{
		if (hasVacancy())
		{
			// create room and assign colony
			Room rm = rf.getRoom(rmtype, amenities);
			rm.setRoomColony(rc);
			rooms.add(rm);
			return rm;
		}
		else
		{
			System.out.println("No vacancy, colony will be moved to waitlist");
			wlist.addObserver(rc);
			System.out.println(wlist);
			return null;
		}
	}

	public void checkout(Room rm, PaymentStrategy ps)
	{
		if(rooms.contains(rm)) {
			Bill bill = new Bill();
			Charge roomCost = new Charge(rm.getDescription(), rm.getCost() * rm.getNights());
			bill.addCharge(roomCost);
			log.addTransaction(bill.toString());
			log.addTransaction(bill.payBill(ps));
			rooms.remove(rm);
			wlist.notifyObservers();
			wlist = new Waitlist();
		}
	}

	public void clean()
	{
		for (Room r : rooms)
		{
			r.accept(m);
			sprayRoom(r);
			r.incNights();
		}
	}

	/**
	 * cullRoom reduces the population by a factor of .5 or .25
	 * 
	 * @param rm - Room to be culled
	 */
	private void sprayRoom(Room rm)
	{
		if (rm.getDescription().contains("Shower"))
		{
			if(rm.getColony().spray(true)) {
				System.out.println("Room has been sprayed for bugs");
				System.out.println(rm.getColony());
			}
		}
		else {
			if(rm.getColony().spray(false)) {
				System.out.println("Room has been sprayed for bugs");
				System.out.println(rm.getColony());
			}
		}
	}
	
	public String getLog() {
		return log.toString();
	}

	/**
	 * Returns a String representation of this RoachMotel.
	 * 
	 * @return A String representation of this RoachMotel.
	 */
	public String toString()
	{
		String s = "";
		if (hasVacancy())
			s =  "RoachMotel: Open Rooms | # of Rooms occupied: " + rooms.size() + "\n";
		else {
			s = "RoachMotel: No Vacancy";
			return s;
		}
		
		for(Room room : rooms) {
			s += room.toString() + "\n";
		}
		return s;
	}
}
