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

import java.util.LinkedList;
import java.util.List;

/**
 * Class to store a person and their first/last name
 * @author Daniel de Monteiro, Connor Hanson, Mitchell Alley, George Khankeldian
 *
 */
public class Person {
	//Store name and password
	private String name;
	private String passWord;
	
	/**
	 * Constructor to assign name
	 * @param firstName is the first name of the person
	 * @param lastName is the last name of the person
	 */
	public Person(String name) {
		this.name = name;
	}
	
	/**
	 * Constructor to assign name and password
	 * @param firstName is the first name of the person
	 * @param lastName is the last name of the person
	 */
	public Person(String name, String password) {
		this.name = name;
		this.passWord = password;
	}
	
	public String getPassword() {
		return this.passWord;
	}
	
	public void setPassword(String password) {
		this.passWord = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
