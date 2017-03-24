package credits.tools.readers;

import java.util.Collection;
import java.util.Map;

/**
 * @author Maxcim
 *
 */
public abstract class FilesReader {

	public abstract Collection<?> readFile(String fileAdress);

	public static void createValueMap(Map<String, Integer> valueMap, String[] values) {
		int counter = 0;
		trimStringValues(values);
		for (int i = 0; i < values.length; i++) {
			valueMap.put(values[i], counter++);
		}
	}

	public static void trimStringValues(String[] values) {
		for (int i = 0; i < values.length; i++) {
			values[i] = values[i].trim();
		}
	}

	public static String extractValues(Map<String, Integer> valueMap, String[] values, String key) {
		String surName = values[valueMap.get(key)];
		return surName;
	}

	public static void printErrorLineNumber(String fileAdress, int countLineError) {
		if (countLineError == 0) {
			System.out.println("The data successfully loaded from " + fileAdress + ".");
		} else {
			System.out.println("\nCheck the file " + fileAdress + ". Because " + countLineError
					+ " line hadn't been read because the information is incorrect or isn't full.\n");
		}
	}
}
