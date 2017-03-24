/**
 * 
 */
package credits.tools;

import static credits.tools.UserInput.getUserInput;

import java.util.MissingResourceException;

import credits.beans.bank.Bank;
import credits.tools.readers.ManadgerReader;
import credits.tools.readers.OffersReader;

/**
 * @author Maxcim
 *
 */
public class CreditsSystemCreator {
	public static Bank createBank(String bankName) {
		printWelcomeText(bankName);
		Bank bank = new Bank();
		bank.setName(bankName);
		printPathDefault();
		String offerFileAdress = "resources/offers.txt";
		String manadgerFileAdress = "resources/manadgers.txt";
		printConfirm();
		bank.setManadgersSet(new ManadgerReader().readFile(manadgerFileAdress));
		bank.setOffersList(new OffersReader().readFile(offerFileAdress));
		printSeparator();
		return bank;
	}

	public static Bank createBank(String fileMessageProperties, String bankName) {
		printWelcomeText(bankName);
		Bank bank = new Bank();
		bank.setName(bankName);
		String manadgerFileAdress;
		String offerFileAdress;
		try {
			Messages.setResourceBundle(fileMessageProperties);
			manadgerFileAdress = Messages.getString("Bank.manadgerFileAdress");
			offerFileAdress = Messages.getString("Bank.offerFileAdress");
			printFileInformation(manadgerFileAdress, offerFileAdress);
		} catch (MissingResourceException error) {
			System.out.println(
					"File " + fileMessageProperties + ".properties not found. Please check the path to the file.");
			printPathDefault();
			offerFileAdress = "resources/offers.txt";
			manadgerFileAdress = "resources/manadgers.txt";
		}
		printConfirm();
		bank.setManadgersSet(new ManadgerReader().readFile(manadgerFileAdress));
		bank.setOffersList(new OffersReader().readFile(offerFileAdress));
		printSeparator();
		return bank;
	}

	public static Bank createBank(String offerFileAdress, String manadgerFileAdress, String bankName) {
		printWelcomeText(bankName);
		printFileInformation(manadgerFileAdress, offerFileAdress);
		printConfirm();
		Bank bank = new Bank();
		bank.setName(bankName);
		bank.setManadgersSet(new ManadgerReader().readFile(manadgerFileAdress));
		bank.setOffersList(new OffersReader().readFile(offerFileAdress));
		printSeparator();
		return bank;
	}

	private static void printFileInformation(String manadgerFileAdress, String offerFileAdress) {
		System.out.println("The information about beans will be loading from the files:");
		System.out.println("offers - " + offerFileAdress);
		System.out.println("manadgers - " + manadgerFileAdress + "\n");
	}

	private static void printConfirm() {
		getUserInput("Please check information in the files and then press enter...");
		printSeparator();
	}

	private static void printPathDefault() {
		System.out.println("The path to offer file set by default Bank/resources/offers.txt");
		System.out.println("The path to manadger file set by default Bank/resources/manadgers.txt\n");
	}

	private static void printWelcomeText(String bankName) {
		printSeparator();
		System.out.println("The creation of Bank \"" + bankName + "\" has been started...\n");
	}

	private static void printSeparator() {
		System.out.println("===================================================================================");
	}
}
