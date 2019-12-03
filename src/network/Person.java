package network;

public class Person {
	private String firstName = null;
	private String lastName = null;
	
	/**
	 * Constructor to assign first and last names
	 * @param firstName is the first name of the person
	 * @param lastName is the last name of the person
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
