/**
 * 
 */
package credits.beans.credits;

import credits.exception.OfferException;
import credits.interfaces.TakeNeedCredit;

/**
 * @author Maxcim
 *
 */
public class Need extends Credit implements TakeNeedCredit{

	private static final long serialVersionUID = 1L;

	public Need() {
		super();
	}

	public Need(String nameBank, String nameCredit, String purpose, String valuta, String enrollment, int term,
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
