/**
 * 
 */
package credits.tools;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Maxcim
 *
 */
public class Messages {

	private static ResourceBundle resourceBundle;

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			System.out
					.println("Something wrong with ResourceBundle key = " + key + " in the messages.properties file.");
			UserInput.getUserInput("Press enter to exit and check the file...");
			System.exit(0);
			return "*** check messages.properties ***";
		}
	}

	public static void setResourceBundle(String bundleName) throws MissingResourceException {
		Messages.resourceBundle = ResourceBundle.getBundle(bundleName);
	}

}
