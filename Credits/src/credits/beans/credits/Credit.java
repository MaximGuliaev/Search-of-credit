/**
 * 
 */
package credits.beans.credits;

import credits.beans.offers.Offer;
import credits.exception.OfferException;

/**
 * @author Maxcim
 *
 */
public abstract class Credit extends Offer {

	private static final long serialVersionUID = 1L;

	public Credit() {
		super();
	}

	public Credit(String nameBank, String nameCredit, String purpose, String valuta, String enrollment, int term,
			int maxLine, boolean increaseLine, boolean prepayment, int interest) throws OfferException {
		super(nameBank, nameCredit, purpose, valuta, enrollment, term, maxLine, increaseLine, prepayment, interest);
	}

	@Override
	public void maintain() {
		System.out.println("We maintain yuors offer for credit.");

	}

}
