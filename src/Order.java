/**
 * Jun Feng 
 * 109787640
 * HW #1
 * CSE 214.08
 * Michael Rizzo
 * Grading TA unknown
 * @author Feng
 **/

/**
 * This class contain the data field for the Order. It includes constructor,
 * getter, mutator, toString methods.
 * 
 * @author Jun Feng
 */
public class Order {
	/**
	 * name of the order
	 */
	private String order;
	/**
	 * name of the specialInstruction
	 */
	private String specialInstruction;
	/**
	 * price of the order
	 */
	private double price;

	/**
	 * default constructor
	 */
	public Order() {

	}

	/**
	 * Creates Order object with parameters of
	 * 
	 * @param order
	 *            String
	 * @param specialInstruction
	 *            String
	 * @param price
	 *            double postcondition order object has been initialized to an
	 *            order with name and price
	 */
	public Order(String name, String specialInstruction, double price) {
		this.order = name;
		this.specialInstruction = specialInstruction;
		this.price = price;
	}

	/**
	 * Set the name of the Order by user input
	 * 
	 * @param Order
	 *            String
	 */
	public void setOrder(String Order) {
		this.order = order;
	}

	/**
	 * Set the SpecialInstruction
	 * 
	 * @param specialInstruction
	 *            String
	 */
	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}

	/**
	 * Set the price of the order
	 * 
	 * @param price
	 *            double
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Retrieve the name of the order
	 * 
	 * @return order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * Retrieves the specialInstruction
	 * 
	 * @return specialInstruction
	 */
	public String getSpecialInstruction() {
		return specialInstruction;
	}

	/**
	 * Retrieve the price of the order
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Create a equal method compare two order object
	 * 
	 * @param obj
	 *            Object
	 * @return true if same property false if different
	 */
	public boolean equals(Object obj) {
		if (((Order) obj).getOrder().equals(this.getOrder())
				&& ((Order) obj).getSpecialInstruction().equals(this.getSpecialInstruction())
				&& ((Order) obj).getPrice() == (this.getPrice())) {
			return true;
		}
		return false;

	}

	/**
	 * Print the order information
	 * 
	 * @return a String with order information
	 */
	@Override
	public String toString() {
		String information = "";
		information = String.format("%-15s %-55s %.2f \n", order, specialInstruction, price);
		return information;
	}
}
