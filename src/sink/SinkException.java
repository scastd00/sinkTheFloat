package sink;

/**
 * Custom exception for the game.
 */
public class SinkException extends Exception {

	/**
	 * ID of the exception.
	 */
	private static final long serialVersionUID = 0x1234abcd;

	/**
	 * Constructor of Exceptions used in the game.
	 *
	 * @param msg message of the exception.
	 */
	public SinkException(String msg) {
		super(msg);
	}
}
