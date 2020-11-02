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
 * creates an exception indicates end of list
 * 
 * @author Jun Feng
 *
 */
public class EndOfListException extends Exception {
	@Override
	public String getMessage() {
		return "Cursor is null.";
	}
}
