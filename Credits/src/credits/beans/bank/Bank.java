/**
 * 
 */
package credits.beans.bank;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import credits.beans.offers.Offer;
import credits.beans.persons.Manadger;

/**
 * @author Maxcim
 *
 */
public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private List<Offer> offersList;

	private Set<Manadger> manadgersSet;

	public Bank() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Offer> getOffersList() {
		return offersList;
	}

	public void setOffersList(List<Offer> offersList) {
		this.offersList = offersList;
	}

	public Set<Manadger> getManadgersSet() {
		return manadgersSet;
	}

	public void setManadgersSet(Set<Manadger> manadgersSet) {
		this.manadgersSet = manadgersSet;
	}

	public void acceptRequest() {
		System.out.println("Dear Customer. Your request is accepted. We'll send you the offer.");
		sendOffer();
	}

	private void sendOffer() {
		System.out.println("The offer was sended.");
	}

	@Override
	public String toString() {
		return "Bank:" + name + "[offersList=" + offersList + ", manadgersSet=" + manadgersSet + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manadgersSet == null) ? 0 : manadgersSet.hashCode());
		result = prime * result + ((offersList == null) ? 0 : offersList.hashCode());
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
		Bank other = (Bank) obj;
		if (manadgersSet == null) {
			if (other.manadgersSet != null)
				return false;
		} else if (!manadgersSet.equals(other.manadgersSet))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (offersList == null) {
			if (other.offersList != null)
				return false;
		} else if (!offersList.equals(other.offersList))
			return false;
		return true;
	}

}
