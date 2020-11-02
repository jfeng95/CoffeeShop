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
 * Creates a OrderList Object
 * 
 * @author Jun Feng
 *
 */
public class OrderList {
	/**
	 * instantiate head node
	 */
	private OrderListNode head;
	/**
	 * instantiate tail node
	 */
	private OrderListNode tail;
	/**
	 * instantiate cursor node
	 */
	private OrderListNode cursor;
	/**
	 * instantiate mergecursor node
	 */
	private OrderListNode mergecursor;
	/**
	 * number of object
	 */
	private int count;
	/**
	 * Header Format
	 */
	private String header = String.format("%-15s %-55s %-35s", "Drink name", "Special Instruction", "price") + "\n"
			+ "----------------------------------------------------------------------------" + "\n";

	/**
	 * creates an empty OrderList
	 */
	public OrderList() {
		this.head = null;
		this.tail = null;
		this.cursor = null;
		this.count = 0;
	}

	/**
	 * getter for number of object
	 * 
	 * @return count int
	 */
	public int numOrders() {
		return count;
	}

	/**
	 * Get the information of the Order at the cursor
	 * 
	 * @return data of order object
	 */
	public Order getCursorOrder() {
		return cursor.getdata();
	}

	/**
	 * Set the cursor to head
	 */
	public void resetCursorToHead() {
		if (head == null) {
			cursor = null;
		} else {
			cursor = head;
		}
	}
	/**
	 * Set the mergecursor to head
	 */
	public void resetMergeCursor() {
		if (head == null) {
			mergecursor = null;
		} else {
			mergecursor = head;
		}
	}

	/**
	 * Set the cursor to tail
	 */
	public void resetCursorToTail() {
		if (tail == null) {
			cursor = null;
			System.out.println("There is no order.");
		} else {
			cursor = tail;
			System.out.println("The cursor is pointed to tail");
		}
	}

	/**
	 * move the cursor to select the next OrderList Node
	 * 
	 * @throws EndOfListException
	 *             indicate the end of list
	 */
	public void cursorForward() throws EndOfListException {
		if (cursor.getNext() == null) {
			throw new EndOfListException();
		} else {
			cursor = cursor.getNext();
			System.out.println("Cursor moved forward");
		}
	}

	/**
	 * move the cursor to select previous OrderListNode
	 * 
	 * @throws EndOfListException
	 *             indicate the end of list
	 */
	public void cursorBackward() throws EndOfListException {
		if (cursor.getPrev() == null) {
			throw new EndOfListException();
		} else {
			cursor = cursor.getPrev();
			System.out.println("Cursor moved backward");
		}
	}

	/**
	 * Inserts the indicated Order after the cursor
	 * 
	 * @param newOrder
	 *            Order data entry
	 * @throws IllegalArgumentException
	 *             input is invalid
	 */
	public void insertAfterCursor(Order newOrder) throws IllegalArgumentException {
		if (newOrder == null) {
			throw new IllegalArgumentException("new Order is null");
		}
		OrderListNode newNode = new OrderListNode(newOrder);
		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.setNext(null);
			newNode.setPrev(null);
			cursor = newNode;
		} else if (cursor.getNext() == null) {
			cursor.setNext(newNode);
			newNode.setPrev(cursor);
			newNode.setNext(null);
			tail = newNode;
			cursor = newNode;
		} else {
			newNode.setNext(cursor.getNext());
			newNode.setPrev(cursor);
			cursor.setNext(newNode);
			newNode.getNext().setPrev(newNode);
			cursor = newNode;
		}
		count++;
	}
	/**
	 * merge two order
	 * 
	 * @param newOrder
	 *            Order data entry
	 * @throws IllegalArgumentException
	 *             input is invalid
	 */
	public void Merge(Order newOrder) throws IllegalArgumentException {
		if (newOrder == null) {
			throw new IllegalArgumentException("new Order is null");
		}
		OrderListNode newNode = new OrderListNode(newOrder);
		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.setNext(null);
			newNode.setPrev(null);
			mergecursor = newNode;
		} else if (mergecursor.getNext() == null) {
			mergecursor.setNext(newNode);
			newNode.setPrev(mergecursor);
			newNode.setNext(null);
			tail = newNode;
			mergecursor = newNode;
		} else {
			newNode.setNext(mergecursor.getNext());
			newNode.setPrev(mergecursor);
			mergecursor.setNext(newNode);
			newNode.getNext().setPrev(newNode);
			mergecursor = newNode.getNext();
		}
		count++;
	}
	/**
	 * Inserts the indicated Order after the tail of the list
	 * 
	 * @param newOrder
	 *            new order entry
	 * @throws IllegalArgumentException
	 *             input is invalid
	 */
	public void appendToTail(Order newOrder) throws IllegalArgumentException {
		if (newOrder == null) {
			throw new IllegalArgumentException("newOrder is null");
		}
		OrderListNode newNode = new OrderListNode(newOrder);
		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.setNext(null);
			newNode.setPrev(null);
			cursor = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			newNode.setNext(null);
			tail = newNode;
		}
		count++;
	}

	/**
	 * Inserts the indicated Order as the head of the list
	 * 
	 * @param newOrder
	 *            new order entry
	 * @throws IllegalArgumentException
	 *             input is invalid
	 */
	public void appendToHead(Order newOrder) throws IllegalArgumentException {
		if (newOrder == null) {
			throw new IllegalArgumentException("newOrder is null");
		}
		OrderListNode newNode = new OrderListNode(newOrder);
		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.setNext(null);
			newNode.setPrev(null);
			cursor = newNode;
		} else {
			newNode.setPrev(null);
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		}
		count++;
	}

	/**
	 * removes the OrderListNode referenced by cursor
	 * 
	 * @return the Order
	 * @throws EndOfListException
	 *             indicates the end of the list
	 */
	public Order removeCursor() throws EndOfListException {
		if (cursor == null) {
			throw new EndOfListException();
		}
		Order removedOrder = cursor.getdata();
		if (count == 1) {
			head = null;
			cursor = null;
			tail = null;
		} else if (cursor == head) {
			cursor.getNext().setPrev(null);
			cursor = cursor.getNext();
			head = cursor;
		} else if (cursor == tail) {
			cursor.getPrev().setNext(null);
			cursor = cursor.getPrev();
			tail = cursor;
		} else {
			cursor.getNext().setPrev(cursor.getPrev());
			cursor.getPrev().setNext(cursor.getNext());
			cursor = cursor.getPrev();
		}
		count--;
		return removedOrder;
	}

	/**
	 * put the similar order together
	 * 
	 * @param newOrder
	 *            new order
	 * @throws IllegalArgumentException
	 *             invalid order
	 */
	public void AddToSimilarOrder(Order newOrder) throws IllegalArgumentException {
		if (newOrder == null) {
			throw new IllegalArgumentException("new Order is null");
		}
		OrderListNode newNode = new OrderListNode(newOrder);
		if (head != null) {
			OrderListNode tempCursor = head;
			while (tempCursor != null) {
				if (tempCursor.getdata().equals(newOrder)) {
					if (tempCursor.getNext() == null) {
						tempCursor.setNext(newNode);
						newNode.setPrev(tempCursor);
						tail = newNode;
						return;
					} else {
						newNode.setNext(tempCursor.getNext());
						newNode.setPrev(tempCursor);
						tempCursor.setNext(newNode);
						newNode.getNext().setPrev(newNode);
						return;
					}
				}
				tempCursor = tempCursor.getNext();
			}
			this.appendToTail(newOrder);
		}

	}

	/**
	 * reverse the order list
	 * 
	 */
	public void reverse() {
		OrderListNode temp = head;
		head = tail;
		tail = temp;
		OrderListNode current = head;
		while (current != null) {
			temp = current.getNext();
			current.setNext(current.getPrev());
			current.setPrev(temp);
			current = current.getNext();
		}
	}

	/**
	 * print out the orders
	 * 
	 * @return print String
	 */
	public String toString() {
		String print = header;
		OrderListNode tempCursor = head;
		if (head != null) {
			while (tempCursor != null) {
				if (tempCursor == cursor) {
					print = print + "->" + tempCursor.toString();
				} else {
					print = print + tempCursor.toString();
				}
				tempCursor = tempCursor.getNext();
			}
		}

		return print;
	}
}
