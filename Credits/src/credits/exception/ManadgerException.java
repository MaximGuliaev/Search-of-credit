/**
 * 
 */
package credits.exception;

/**
 * @author Maxcim
 *
 */
public class ManadgerException extends Exception {

	public static final long serialVersionUID = 1L;

	public ManadgerException() {
	}

	public ManadgerException(String message) {
		super(message);
	}

	public ManadgerException(Throwable cause) {
		super(cause);
	}

	public ManadgerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ManadgerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
