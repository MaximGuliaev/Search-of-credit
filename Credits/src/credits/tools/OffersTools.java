/**
 * 
 */
package credits.tools;

import static credits.tools.UserInput.getUserInput;
import static credits.tools.UserInput.stringToIntegerInput;

import java.util.Collections;
import java.util.List;

import credits.beans.offers.Offer;
import credits.enums.OffersSortIndex;
import credits.exception.BankException;
import credits.tools.comparator.OffersComparator;

/**
 * @author Maxcim
 *
 */
public class OffersTools {

	public static void findOffersWithMaxLine(List<Offer> offersList) throws BankException {
		checkOfferList(offersList);
		Integer minimumLine = getMinimumLine();
		Integer maximumLine = getMaximumLine(minimumLine);
		System.out.printf("\nWe try to find offers with maximum line between %,d and %,d :\n", minimumLine,
				maximumLine);
		System.out.println();
		OffersTools.sortMaxLine(offersList);
		findExactLineOffer(offersList, minimumLine, maximumLine);
	}

	private static void findExactLineOffer(List<Offer> offersList, Integer minimumLine, Integer maximumLine) {
		int count = 0;
		for (Offer offer : offersList) {
			if (offer.getMaxLine() >= minimumLine && offer.getMaxLine() <= maximumLine) {
				System.out.printf("%s   maxLine= %,d \n", offer, offer.getMaxLine());
				count++;
			}
			if (count == 0) {
				System.out.printf("There are no offers with max line bettween %,d and %,d in the bank.\n",
						minimumLine, maximumLine);
			}
		}
	}

	public static List<Offer> sortTerm(List<Offer> offersList) throws BankException {
		checkOfferList(offersList);
		Collections.sort(offersList, new OffersComparator(OffersSortIndex.TERM));
		return offersList;
	}

	private static List<Offer> sortMaxLine(List<Offer> offersList) throws BankException {
		checkOfferList(offersList);
		Collections.sort(offersList, Collections.reverseOrder(new OffersComparator(OffersSortIndex.MAX_LINE)));
		return offersList;
	}

	private static void checkOfferList(List<Offer> offersList) throws BankException {
		if (offersList.isEmpty()) {
			throw new BankException("There are no offer in the bank.");
		}
	}

	private static Integer getMaximumLine(Integer minimumLine) {
		Integer maximumLine = null;
		maximumLine = stringToIntegerInput(getUserInput("Please enter maximum line that you want to find:"));
		while (maximumLine == null || maximumLine <= minimumLine) {
			maximumLine = stringToIntegerInput(
					getUserInput("Please enter the correct maximum line (>" + minimumLine + "):"));
		}
		return maximumLine;
	}

	private static Integer getMinimumLine() {
		Integer minimumLine = null;
		minimumLine = stringToIntegerInput(getUserInput("\nPlease enter minimum line that you want to find:"));
		while (minimumLine == null || minimumLine < 0) {
			minimumLine = stringToIntegerInput(getUserInput("Please enter the correct minimum line (>= 0):"));
		}
		return minimumLine;
	}

}
