/**
 * 
 */
package credits.beans.persons;

import java.util.Calendar;

import credits.enums.Gender;
import credits.exception.ManadgerException;

/**
 * @author Maxcim
 *
 */
public class Manadger extends Person implements Comparable<Manadger> {

	private static final long serialVersionUID = 1L;

	Calendar joined;
	String certification;

	public Manadger(String surName, String firstName, String phone, int age, Gender gender, Calendar joined,
			String certification) throws ManadgerException {
		super(surName, firstName, phone, age, gender);
		if (!checkManadgerFields(surName, firstName, phone, age, gender, joined, certification)) {
			throw new ManadgerException();
		}
		;
		this.joined = joined;
		this.certification = certification;
	}

	private boolean checkManadgerFields(String surName, String firstName, String phone, int age, Gender gender,
			Calendar joined, String certification) {
		int countError = 0;
		int maxYearWork = 80;
		Calendar maxDate = Calendar.getInstance();
		Calendar minAgeDate = Calendar.getInstance();
		minAgeDate.add(Calendar.YEAR, -age);
		Calendar minDate = Calendar.getInstance();
		minDate.add(Calendar.YEAR, -maxYearWork);
		if (age < 18 || age > 100) {
			System.out.println(surName + " " + firstName + " : age is incorrect.");
			countError++;
		}
		if (gender == null) {
			System.out.println(surName + " " + firstName + " : gender is incorrect.");
			countError++;
		}
		if (joined.after(maxDate) || joined.before(minDate) || joined.before(minAgeDate)) {
			System.out.println(surName + " " + firstName + " : joined date is incorrect.");
			countError++;
		}
		if (countError == 0) {
			return true;
		} else {
			return false;
		}
	}

	public Manadger() {
		super();
	}

	@Override
	void work() {
		System.out.println("I go to work every day. I'm manadger in the bank.");
	}

	@Override
	public String toString() {
		return String.format("%-8s %-8s phone: %s, work since %tF", surName, firstName, phone, joined);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((certification == null) ? 0 : certification.hashCode());
		result = prime * result + ((joined == null) ? 0 : joined.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manadger other = (Manadger) obj;
		if (certification == null) {
			if (other.certification != null)
				return false;
		} else if (!certification.equals(other.certification))
			return false;
		if (joined == null) {
			if (other.joined != null)
				return false;
		} else if (!joined.equals(other.joined))
			return false;
		return true;
	}

	public Calendar getJoined() {
		return joined;
	}

	public String getCertification() {
		return certification;
	}

	@Override
	public int compareTo(Manadger manadger) {
		int result = (firstName + surName).compareToIgnoreCase(manadger.getFirstName() + manadger.getSurName());
		return result;
	}

	@Override
	public void print() {
				
	}
}
