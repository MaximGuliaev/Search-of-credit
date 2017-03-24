/**
 * 
 */
package credits.tools.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import credits.beans.persons.Manadger;
import credits.enums.Gender;
import credits.exception.ManadgerException;

/**
 * @author Maxcim
 *
 */
public class ManadgerReader extends FilesReader {
	@Override
	public Set<Manadger> readFile(String fileAdress) {
		BufferedReader reader = null;
		Set<Manadger> manadgerSet = new TreeSet<Manadger>();
		Map<String, Integer> manadgerValueMap = new HashMap<>();
		try {
			reader = new BufferedReader(new FileReader(fileAdress));
			String temp = "";

			if ((temp = reader.readLine()) != null) {
				String[] manadgerValues = temp.split(";");
				createValueMap(manadgerValueMap, manadgerValues);
				int countLineError = 0;
				while ((temp = reader.readLine()) != null) {
					manadgerValues = temp.split(";");
					trimStringValues(manadgerValues);
					if (manadgerValues.length != manadgerValueMap.size()) {
						countLineError++;
						continue;
					}
					String surName = extractValues(manadgerValueMap, manadgerValues, "surName");
					String firstName = extractValues(manadgerValueMap, manadgerValues, "firstName");
					String phone = extractValues(manadgerValueMap, manadgerValues, "phone");
					String personGender = extractValues(manadgerValueMap, manadgerValues, "gender");
					String joinedDate = extractValues(manadgerValueMap, manadgerValues, "joined");
					String certification = extractValues(manadgerValueMap, manadgerValues, "certification");
					Gender gender = defineGender(personGender); //
					Manadger manadger;
					try {
						int age = Integer.parseInt(extractValues(manadgerValueMap, manadgerValues, "age"));
						Calendar joined = defineDate(joinedDate);
						manadger = new Manadger(surName, firstName, phone, age, gender, joined, certification);
						manadgerSet.add(manadger);
					} catch (ManadgerException e) {
						countLineError++;
						System.out.println();
						System.out.println(surName + " " + firstName
								+ " hasn't been added to manadgers list. Please correct the data in the file "
								+ fileAdress + ".");
					} catch (NumberFormatException e) {
						countLineError++;
						System.out.println();
						System.out.println(surName + " " + firstName
								+ " hasn't been added to manadgers list. Please check the age format (must be integer) in the file "
								+ fileAdress + ".");
					}
				}
				printErrorLineNumber(fileAdress, countLineError);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileAdress + " not found. Please check the path to the file.\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return manadgerSet;
	}

	private Calendar defineDate(String stringDate) throws ManadgerException {
		String[] dateArray = stringDate.split("\\.");
		Calendar date;
		try {
			date = new GregorianCalendar(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]),
					Integer.parseInt(dateArray[2]));
		} catch (NumberFormatException e) {
			System.out.println("Please check the format of birth date (YYYY.MM.DD) in the file. ");
			throw new ManadgerException();
		}
		return date;
	}

	private Gender defineGender(String personGender) {
		Gender gender;
		if (personGender.equalsIgnoreCase("man")) {
			gender = Gender.MAN;
		} else if (personGender.equalsIgnoreCase("woman")) {
			gender = Gender.WOMAN;
		} else {
			gender = null;
		}
		return gender;
	}

}