/**
 * Filename:   Person.java
 * 
 * Name: Daniel de Monteiro
 * Email: demonteiro@wisc.edu
 * Class: CS400 - Debra Deppeler
 * Lecture Number: LEC 002
 * 
 * Name: Connor Hanson
 * Email: cbhanson2@wisc.edu
 * Class: CS400 - Debra Deppeler
 * Lecture Number: LEC 002
 * 
 * Name: Mitchell Alley
 * Email: mgalley@wisc.edu
 * Class: CS400 - Debra Deppeler
 * Lecture Number: LEC 001
 * 
 * Name: George Khankeldian
 * Email: khankeldian@wisc.edu
 * Class: CS400 - Debra Deppeler
 * Lecture Number: LEC 002
 * 
 * Due Date: December 3, 2019
 * 
 * Project Name: a2 ATEAM Project Milestone 2 GUI
 * Description: Create a GUI to show the social network
 */

package application;

/**
 * Class to store a person and their first/last name
 * @author Daniel de Monteiro, Connor Hanson, Mitchell Alley, George Khankeldian
 *
 */
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
