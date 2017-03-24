/**
 * 
 */
package credits.tools;

import static credits.tools.UserInput.getUserInput;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import credits.beans.bank.Bank;
import credits.beans.offers.Offer;
import credits.beans.persons.Manadger;
import credits.exception.BankException;
import credits.tools.writers.BankFileWriter;

/**
 * @author Maxcim
 *
 */
public class InterfaceMenu {

	public static void showConsoleMenu(Bank bank) {
		List<Offer> offersList = bank.getOffersList();
		Set<Manadger> manadgersSet = bank.getManadgersSet();
		while (true) {
			String key = null;
			System.out.println("\nPlease, choose the option and enter the number:");
			System.out.println("  enter 1 - show the offers list;");
			System.out.println("  enter 2 - show the manadgers list;");
			System.out.println("  enter 3 - sort the offers by term;");
			System.out.println("  enter 4 - find the offers with defining maximum line;");
			System.out.println("  enter 5 - write information about bank in the files/bank.txt;");
			key = getUserInput("  enter e - exit from program");
			while (key == null) {
				key = getUserInput("Please enter the number 1...5 or e - to exit.");
			}
			try {
				switch (key) {
				case "1":
					showOffersList(offersList);
					break;
				case "2":
					showManadgersList(manadgersSet);
					break;
				case "3":
					offersList = OffersTools.sortTerm(offersList);
					showOffersList(offersList);
					break;
				case "4":
					OffersTools.findOffersWithMaxLine(offersList);
					break;
				case "5":
					BankFileWriter.writeBankFile("files/bank.txt", bank);
					break;
				case "e":
					System.exit(0);
					break;
				default:
					System.out.println("\nPlease, enter the correct number 1...5 or e - to exit.");
					break;
				}
			} catch (BankException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void showOffersList(List<Offer> offersList) throws BankException {
		System.out.println();
		if (offersList.isEmpty()) {
			throw new BankException("There are no offer in the bank.");
		} else {
			for (Offer offer : offersList) {
				System.out.printf("Bank: \"%s\", credit: \"%s\", purpose: %s, term: %d months,  valuta: %s,  maxLine: %,d\n", offer.getNameBank(), offer.getNameCredit(), offer.getPurpose(), offer.getTerm(), offer.getValuta(), offer.getMaxLine());
			}
		}

	}

	private static void showManadgersList(Set<Manadger> manadgersSet) throws BankException {
		System.out.println();
		if (manadgersSet.isEmpty()) {
			throw new BankException("There are no manadgers in the bank.");
		} else {
			Iterator<Manadger> manadgerIterator = manadgersSet.iterator();
			while (manadgerIterator.hasNext()) {
				System.out.println(manadgerIterator.next());
			}
		}
	}
}
