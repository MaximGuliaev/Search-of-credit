/**
 * 
 */
package credits.beans.offers;

import java.io.Serializable;

import credits.exception.OfferException;
import credits.interfaces.Maintainable;
import credits.interfaces.Printable;

/**
 * @author Maxcim
 *
 */
public abstract class Offer implements Maintainable, Serializable, Comparable<Offer>, Printable {

	private static final long serialVersionUID = 1L;

	public static int numberOfferCreated = 0;

	protected String nameBank;
	protected String nameCredit;
	protected String purpose;
	protected String valuta;
	protected String enrollment;

	protected int term;
	protected int maxLine;
	protected int interest;

	protected boolean prepayment;
	protected boolean increaseLine;

	public Offer(String nameBank, String nameCredit, String purpose, String valuta, String enrollment, int term,
			int maxLine, boolean increaseLine, boolean prepayment, int interest) throws OfferException {
		super();
		if (!checkOfferFields(nameBank, nameCredit, purpose, valuta, enrollment, term, maxLine, increaseLine,
				prepayment, interest)) {
			throw new OfferException();
		}
		this.nameBank = nameBank;
		this.nameCredit = nameCredit;
		this.purpose = purpose;
		this.valuta = valuta;
		this.enrollment = enrollment;
		this.term = term;
		this.maxLine = maxLine;
		this.interest = interest;
		this.prepayment = prepayment;
		this.increaseLine = increaseLine;
		Offer.numberOfferCreated++;
	}

	private boolean checkOfferFields(String nameBank, String nameCredit, String purpose, String valuta,
			String enrollment, int term, int maxLine, boolean increaseLine, boolean prepayment, int interest) {
		int countError = 0;
		if (term <= 0) {
			System.out.println(nameBank + " " + nameCredit + " : loan term is incorrect.");
			countError++;
		}
		if (maxLine <= 0) {
			System.out.println(nameBank + " " + nameCredit + " : maxsimum line is incorrect.");
			countError++;
		}
		if (interest <= 0) {
			System.out.println(nameBank + " " + nameCredit + " : interest is incorrect.");
			countError++;
		}
		if (countError == 0) {
			return true;
		} else {
			return false;
		}
	}

	public Offer() {
		super();
		Offer.numberOfferCreated++;
	}

	public String getNameBank() {
		return nameBank;
	}

	public String getNameCredit() {
		return nameCredit;
	}

	public String getPurpose() {
		return purpose;
	}

	public String getValuta() {
		return valuta;
	}

	public String getEnrollment() {
		return enrollment;
	}

	public int getTerm() {
		return term;
	}

	public int getMaxLine() {
		return maxLine;
	}

	public int getInterest() {
		return interest;
	}

	public boolean isPrepayment() {
		return prepayment;
	}

	public boolean isIncreaseLine() {
		return increaseLine;
	}

	public void setNameBank(String nameBank) {
		this.nameBank = nameBank;
	}

	public void setNameCredit(String nameCredit) {
		this.nameCredit = nameCredit;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public void setMaxLine(int maxLine) {
		this.maxLine = maxLine;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public void setPrepayment(boolean prepayment) {
		this.prepayment = prepayment;
	}

	public void setIncreaseLine(boolean increaseLine) {
		this.increaseLine = increaseLine;
	}

	public boolean takeCredit(int line) {
		if (line <= maxLine) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Offer o) {
		return nameBank.compareTo(o.getNameBank());
	}

	@Override
	public String toString() {
		return String.format("Bank: \"%s\", credit: \"%s\"", this.getNameBank(), this.getNameCredit(), nameBank, nameCredit);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enrollment == null) ? 0 : enrollment.hashCode());
		result = prime * result + (increaseLine ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(interest);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + maxLine;
		result = prime * result + ((nameBank == null) ? 0 : nameBank.hashCode());
		result = prime * result + ((nameCredit == null) ? 0 : nameCredit.hashCode());
		result = prime * result + (prepayment ? 1231 : 1237);
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + term;
		result = prime * result + ((valuta == null) ? 0 : valuta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		if (enrollment == null) {
			if (other.enrollment != null)
				return false;
		} else if (!enrollment.equals(other.enrollment))
			return false;
		if (increaseLine != other.increaseLine)
			return false;
		if (Double.doubleToLongBits(interest) != Double.doubleToLongBits(other.interest))
			return false;
		if (maxLine != other.maxLine)
			return false;
		if (nameBank == null) {
			if (other.nameBank != null)
				return false;
		} else if (!nameBank.equals(other.nameBank))
			return false;
		if (nameCredit == null) {
			if (other.nameCredit != null)
				return false;
		} else if (!nameCredit.equals(other.nameCredit))
			return false;
		if (prepayment != other.prepayment)
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (term != other.term)
			return false;
		if (valuta == null) {
			if (other.valuta != null)
				return false;
		} else if (!valuta.equals(other.valuta))
			return false;
		return true;
	}

}
