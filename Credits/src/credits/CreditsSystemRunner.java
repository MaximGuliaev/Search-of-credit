/**
 * 
 */
package credits;

import credits.beans.bank.Bank;
import credits.tools.CreditsSystemCreator;
import credits.tools.InterfaceMenu;

/**
 * @author Maxcim
 *
 */
public class CreditsSystemRunner{

	public static void main(String[] args) {
		Bank bank = CreditsSystemCreator.createBank("Always near.");
		InterfaceMenu.showConsoleMenu(bank);
	}
}
