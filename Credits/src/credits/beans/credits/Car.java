/**
 * 
 */
package credits.beans.credits;

import credits.exception.OfferException;
import credits.interfaces.TakeCarCredit;

/**
 * @author Maxcim
 *
 */
public class Car extends Credit implements TakeCarCredit {

	private static final long serialVersionUID = 1L;

	public Car() {
		super();
	}

	public Car(String nameBank, String nameCredit, String purpose, String valuta, String enrollment, int term,
			int maxLine, boolean increaseLine, boolean prepayment, int interest) throws OfferException {
		super(nameBank, nameCredit, purpose, valuta, enrollment, term, maxLine, increaseLine, prepayment, interest);
	}

	@Override
	public void maintain() {
	}

	@Override
	public void print() {
	}

}
