/**
 * 
 */
package credits.tools.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import credits.beans.bank.Bank;
import credits.beans.offers.Offer;
import credits.beans.persons.Manadger;
import credits.exception.BankException;
import credits.interfaces.Printable;

/**
 * @author Maxcim
 *
 */
public class BankFileWriter {

	public static boolean writeBankFile(String file, Bank bank) {
		PrintWriter writer = null;
		boolean result = false;
		List<Offer> offersList = bank.getOffersList();
		Set<Manadger> manadgersSet = bank.getManadgersSet();
		try {
			writer = new PrintWriter(new FileWriter(file));
			writer.println("=================================================================");
			writer.println("The name of Credit search:" + bank.getName());
			writer.println("=================================================================");
			try {
				if (offersList.isEmpty()) {
					throw new BankException("There are no offer in the bank.");
				}
			} catch (BankException e) {
				writer.println(e.getMessage());
			}printInfo(offersList, writer);
			writer.println("=================================================================");
			if (manadgersSet.isEmpty()) {
				writer.println("There are no manadgers in the bank.");
			} else {
				printInfo(manadgersSet, writer);
			}
			writer.println("=================================================================");
			result = true;
			System.out.println("\nThe information was successfully written in the file.");
		} catch (

		IOException e) {
			System.out.println(e);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		return result;
	}

	private static <T extends Printable> void printInfo(Collection<T> collection, PrintWriter writer) {
		Iterator<T> iterator = collection.iterator();
		while (iterator.hasNext()) {
			T object = (T) iterator.next();
			writer.println(object);
		}
	}

}
