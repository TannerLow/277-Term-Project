
public interface RoomVisitor {
	/**
	 * Visit a regular room
	 * @param reg room to visit
	 */
	public void visit(RegularRoom reg);
	/**
	 * Visit a deluxe room
	 * @param del room to visit
	 */
	public void visit(DeluxeRoom del);
	/**
	 * Visit a suite room
	 * @param suite room to visit
	 */
	public void visit(SuiteRoom suite);
}
