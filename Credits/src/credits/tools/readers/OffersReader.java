/**
 * 
 */
package credits.tools.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import credits.beans.credits.Car;
import credits.beans.credits.Construction;
import credits.beans.credits.Need;
import credits.beans.offers.Offer;
import credits.exception.OfferException;

/**
 * @author Maxcim
 *
 */
public class OffersReader extends FilesReader {

	@Override
	public List<Offer> readFile(String fileAdress) {
		BufferedReader reader = null;
		List<Offer> offersList = new ArrayList<>();
		Map<String, Integer> offersValueMap = new HashMap<>();

		try {
			reader = new BufferedReader(new FileReader(fileAdress));
			String temp = "";

			if ((temp = reader.readLine()) != null) {
				String[] offerValues = temp.split(";");
				createValueMap(offersValueMap, offerValues);
				int countLineError = 0;
				while ((temp = reader.readLine()) != null) {
					offerValues = temp.split(";");
					trimStringValues(offerValues);
					if (offerValues.length != offersValueMap.size()) {
						countLineError++;
						continue;
					}
					String nameBank = extractValues(offersValueMap, offerValues, "nameBank");
					String nameCredit = extractValues(offersValueMap, offerValues, "nameCredit");
					String purpose = extractValues(offersValueMap, offerValues, "purpose");
					String valuta = extractValues(offersValueMap, offerValues, "valuta");
					String enrollment = extractValues(offersValueMap, offerValues, "enrollment");
					int term = Integer.parseInt(extractValues(offersValueMap, offerValues, "term"));
					int maxLine = Integer.parseInt(extractValues(offersValueMap, offerValues, "maxLine"));
					int interest = setInterest();
					try {
						boolean prepayment = Boolean.valueOf(extractValues(offersValueMap, offerValues, "prepayment"));
						boolean increaseLine = Boolean
								.valueOf(extractValues(offersValueMap, offerValues, "increaseLine"));
						Offer offer = createOffer(nameBank, nameCredit, purpose, valuta, enrollment, term, maxLine,
								increaseLine, prepayment, interest);
						offersList.add(offer);
					} catch (OfferException e) {
						countLineError++;
						System.out.println(nameBank + " " + nameCredit
								+ " hasn't been added to offers list. Please correct the data in the file " + fileAdress
								+ ".");
					} catch (NumberFormatException e) {
						countLineError++;
						System.out.println(nameBank + " " + nameCredit
								+ " hasn't been added to offers list. Please check the prepayment, increaseLine format (must be boolean) in the file "
								+ fileAdress + ".");
					}
				}
				printErrorLineNumber(fileAdress, countLineError);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileAdress + " not found. Please check the path to the file.");
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
		return offersList;
	}

	private static final String car = null;
	private static final String construction = null;

	private Offer createOffer(String nameBank, String nameCredit, String purpose, String valuta, String enrollment,
			int term, int maxLine, boolean increaseLine, boolean prepayment, int interest) throws OfferException {
		Offer offer;
		if (purpose == car) {
			offer = new Car(nameBank, nameCredit, purpose, valuta, enrollment, term, maxLine, increaseLine, prepayment,
					interest);
		} else if (purpose == construction) {
			offer = new Construction(nameBank, nameCredit, purpose, valuta, enrollment, term, maxLine, increaseLine,
					prepayment, interest);
		} else {
			offer = new Need(nameBank, nameCredit, purpose, valuta, enrollment, term, maxLine, increaseLine, prepayment,
					interest);
		}
		return offer;
	}

	private int setInterest() {
		int interest = (int) (30 + (int) (Math.random() * 0.3) * 0.9);
		return interest;
	}

}
