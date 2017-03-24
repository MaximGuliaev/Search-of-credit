/**
 * 
 */
package credits.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Maxcim
 *
 */
public class UserInput {

	public static String getUserInput(String output) {
		System.out.print(output + " ");
		String inputLine = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if ((inputLine = reader.readLine()) == null) {
				return null;
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		return inputLine;
	}

	public static Integer stringToIntegerInput(String input) {
		Integer number = null;
		if (input != null) {
			try {
				number = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Enter the number with separator \".\"");
			}
		}
		return number;
	}

}
