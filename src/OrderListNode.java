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
 * this class provides the nodes that is able to be used in OrderList
 * 
 * @author Jun Feng
 *
 */
public class OrderListNode {
	/**
	 * the Order's information
	 */
	private Order data;
	/**
	 * initiate next to empty node
	 */
	private OrderListNode next;
	/**
	 * initiate prev to empty node
	 */
	private OrderListNode prev;

	/**
	 * default constructor
	 */
	public OrderListNode() {

	}

	/**
	 * create a constructor
	 * 
	 * @param initdata
	 *            data entered by user
	 * @throws IllegalArgument
	 *             Exception initData is null Precondition initData is not null
	 *             Postconditions OrderListNode has been initialized
	 * 
	 */
	public OrderListNode(Order initData) throws IllegalArgumentException {
		if (initData == null) {
			throw new IllegalArgumentException("Order data is null.");
		}
		this.data = initData;
	}

	/**
	 * Getter for data
	 * 
	 * @return data for Order
	 */
	public Order getdata() {
		return data;
	}

	/**
	 * Set new data for Order objects
	 * 
	 * @param Data
	 *            data for Order object
	 * @throws IllegalArgumentException
	 *             invalid input
	 */
	public void setData(Order newdata) throws IllegalArgumentException {
		if (newdata == null) {
			throw new IllegalArgumentException("Order data is null.");
		}
		this.data = newdata;
	}

	/**
	 * getter for the reference of next node
	 * 
	 * @return the reference for next node
	 */
	public OrderListNode getNext() {
		return next;
	}

	/**
	 * Setting the reference for next
	 * 
	 * @param newNext
	 *            Order object
	 */
	public void setNext(OrderListNode newNext) {
		this.next = newNext;
	}

	/**
	 * getter for the reference of prev node
	 * 
	 * @return the reference for prev node
	 */
	public OrderListNode getPrev() {
		return prev;
	}

	/**
	 * Setting the reference for prev
	 * 
	 * @param newPrev
	 *            Order object
	 */
	public void setPrev(OrderListNode newPrev) {
		this.prev = newPrev;
	}

	/**
	 * To print the node
	 * 
	 * @return the node's data
	 */
	@Override
	public String toString() {
		return data.toString();
	}

}
