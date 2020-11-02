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
 * Create a Coffee Order Manager class which provide the user 
 * with different options
 * @author Jun Feng
 *
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeOrderManager {
	/**
	 * method to print
	 * 
	 * @param in
	 *            a input string to be printed
	 */
	private static void p(String in) {
		System.out.println(in);
	}

	/**
	 * The main class contain a menu which have many operation
	 * 
	 * @param args
	 * @throws IllegalArgumentException
	 *             invalid input
	 * @throws EndOfListException
	 *             indicates the end of the list
	 * @throws InputMismatchException
	 *             wrong input
	 */
	public static void main(String[] args) throws IllegalArgumentException, EndOfListException, InputMismatchException {
		/**
		 * choice of operation
		 */
		String operation = "i";
		/**
		 * Scanner for user input
		 */
		Scanner input = new Scanner(System.in);
		int barnum;
		Order clipboard = new Order();
		Order mergeOrder = new Order();
		OrderList barista[] = new OrderList[3];
		barista[1] = new OrderList();
		barista[2] = new OrderList();
		p("Welcome to Star Duck Coffee");
		while (!operation.equalsIgnoreCase("q")) {
			p("Menu:");
			p("	O-Order");
			p("	P-Print order List");
			p("	E-Extra Credit");
			p("	C-cursor");
			p("	Q- quit");
			p("Please select an option");
			try {
				operation = input.nextLine();
				if (operation.equalsIgnoreCase("O")) {
					p("Please enter drink name:");
					String name = input.nextLine();
					p("Please enter special request:");
					String specialRequest = input.nextLine();
					p("Please enter the price:");
					double price = input.nextDouble();
					input.nextLine();
					p("");
					p("Please select Barista (1 or 2)");
					barnum = input.nextInt();
					input.nextLine();
					while (barnum != 1 && barnum != 2) {
						p("invalid Barista. Please choose again.");
						barnum = input.nextInt();
						input.nextLine();
					}
					p("Where should the order be added?");
					p("Option:");
					p("F-front of the List,	B- Back of List, A- After Cursor, S - After Similar Order");
					p("default: end of List");
					String option = input.nextLine();
					Order neworder = new Order(name, specialRequest, price);
					if (option.equalsIgnoreCase("f")) {
						barista[barnum].appendToHead(neworder);
					} else if (option.equalsIgnoreCase("b")) {
						barista[barnum].appendToTail(neworder);
					} else if (option.equalsIgnoreCase("a")) {
						barista[barnum].insertAfterCursor(neworder);
					} else if (option.equalsIgnoreCase("s")) {
						barista[barnum].AddToSimilarOrder(neworder);
					} else {
						barista[barnum].appendToTail(neworder);
					}
				}
				if (operation.equalsIgnoreCase("P")) {
					p("Barista 1 ");
					p(barista[1].toString());
					p("Barista 2 ");
					p(barista[2].toString());
				}
				if (operation.equalsIgnoreCase("E")) {
					p("M-merge");
					p("R-reverse");
					p("Please enter your choice");
					String option = input.nextLine();
					if (option.equalsIgnoreCase("m")) {
						p("Please select a destination list(1 or 2)");
						barnum = input.nextInt();
						input.nextLine();
						while (barnum != 1 && barnum != 2) {
							p("invalid destination. Please choose again.");
							barnum = input.nextInt();
							input.nextLine();
						}
						barista[1].resetMergeCursor();
						barista[2].resetMergeCursor();
						if(barnum != 1){
							while(barista[1].numOrders()!=0){
								barista[1].resetCursorToHead();
								mergeOrder = barista[1].removeCursor();
								barista[2].Merge(mergeOrder);
							}
						}
						else{
							while(barista[2].numOrders()!=0){
								barista[2].resetCursorToHead();
								mergeOrder = barista[2].removeCursor();
								barista[1].Merge(mergeOrder);
							}
						}
						continue;
					} else if (option.equalsIgnoreCase("r"))
						p("select the barista (1 or 2)");
					barnum = input.nextInt();
					input.nextLine();
					if (barista[barnum].numOrders() != 0) {
						barista[barnum].reverse();
					} else {
						p("There is no order in the list");
					}
				}
				if (operation.equalsIgnoreCase("C")) {
					p("Please select a cursor (1 or 2)");
					barnum = input.nextInt();
					input.nextLine();
					while (barnum != 1 && barnum != 2) {
						p("invalid Barista. Please choose again.");
						barnum = input.nextInt();
						input.nextLine();
					}
					p("Cursor Option:");
					p("F- forward, B- Backward, H-ToHead, T- To Tail, R- Remove, C- Cut, P- Paste");
					String option = input.nextLine();
					while (!option.equalsIgnoreCase("f") && !option.equalsIgnoreCase("b")
							&& !option.equalsIgnoreCase("h") && !option.equalsIgnoreCase("t")
							&& !option.equalsIgnoreCase("r") && !option.equalsIgnoreCase("c")
							&& !option.equalsIgnoreCase("p")) {
						p("invalid option. Please choose again.");
						option = input.nextLine();
					}
					if (option.equalsIgnoreCase("f")) {
						barista[barnum].cursorForward();
					}
					if (option.equalsIgnoreCase("b")) {
						barista[barnum].cursorBackward();
					}
					if (option.equalsIgnoreCase("h")) {
						barista[barnum].resetCursorToHead();
					}
					if (option.equalsIgnoreCase("t")) {
						barista[barnum].resetCursorToTail();
					}
					if (option.equalsIgnoreCase("r")) {
						barista[barnum].removeCursor();
					}
					if (option.equalsIgnoreCase("c")) {
						clipboard = barista[barnum].removeCursor();
					}
					if (option.equalsIgnoreCase("p")) {
						if (clipboard.getOrder() == null) {
							p("nothing on the clipboard");
						} else {
							barista[barnum].appendToTail(clipboard);
							clipboard = null;
						}
					}
				}
				if (operation.equalsIgnoreCase("Q")) {
					p("Only traitors go to Dunkin, see you soon");
					System.exit(0);
				}
			} catch (InputMismatchException exception) {
				p("wrong type of input");
			} catch (NullPointerException exception) {
				p("The cursor is pointing to null");
			} catch (IllegalArgumentException exception) {
				exception.getMessage();
			} catch (EndOfListException exception) {
				p("end of list");
			}
		}
	}
}
