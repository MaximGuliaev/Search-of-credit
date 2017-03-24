/**
 * 
 */
package credits.beans.persons;

import java.io.Serializable;

import credits.enums.Gender;
import credits.interfaces.Printable;

/**
 * @author Maxcim
 *
 */
public abstract class Person implements Serializable, Printable {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The number persons created. */
	public static int numberPersonsCreated = 0;

	/** The surname. */
	protected String surName;

	/** The first name. */
	protected String firstName;

	/** The phone. */
	protected String phone;

	/** The age. */
	protected int age;

	/** The gender. */
	protected Gender gender;

	public Person(String surName, String firstName, String phone, int age, Gender gender) {
		super();
		this.surName = surName;
		this.firstName = firstName;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		Person.numberPersonsCreated++;
	}

	public Person() {
		super();
		Person.numberPersonsCreated++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		return true;
	}

	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	abstract void work();

	@Override
	public String toString() {
		return String.format("Person [surName=%s, firstName=%s, phone=%s]", surName, firstName, phone);
	}

}
