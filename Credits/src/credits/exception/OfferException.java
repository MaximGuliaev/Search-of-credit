package credits.exception;

/**
 * @author Maxcim
 *
 */
public class OfferException extends Exception {

	private static final long serialVersionUID = 1L;

	public OfferException() {
	}

	public OfferException(String message) {
		super(message);
	}

	public OfferException(Throwable cause) {
		super(cause);
	}

	public OfferException(String message, Throwable cause) {
		super(message, cause);
	}

	public OfferException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
