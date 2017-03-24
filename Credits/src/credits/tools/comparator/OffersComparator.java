/**
 * 
 */
package credits.tools.comparator;

import java.util.Comparator;

import credits.beans.offers.Offer;
import credits.enums.OffersSortIndex;

/**
 * @author Maxcim
 *
 */
public class OffersComparator implements Comparator<Offer> {
	private OffersSortIndex sortingIndex;

	@Override
	public int compare(Offer offer1, Offer offer2) {
		switch (sortingIndex) {
		case TERM:
			return (int) (100 * (offer1.getTerm() - offer2.getTerm()));
		case MAX_LINE:
			return (int) (offer1.getMaxLine() - offer2.getMaxLine());
		case INTEREST:
			return (int) (100 * (offer1.getInterest() - offer2.getInterest()));
		default:
			throw new EnumConstantNotPresentException(OffersSortIndex.class, sortingIndex.name());
		}
	}

	public OffersComparator(OffersSortIndex sortingIndex) {
		setSortngIndex(sortingIndex);
	}

	public final void setSortngIndex(OffersSortIndex sortingIndex) {
		if (sortingIndex == null) {
			throw new IllegalArgumentException();
		}
		this.sortingIndex = sortingIndex;
	}

	public OffersSortIndex getSortingIndex() {
		return sortingIndex;
	}
}
