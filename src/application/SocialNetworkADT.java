/**
 * Filename:   SocialNetwork.java
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
 * Due Date: December 11, 2019
 * 
 * Project Name: a3 ATEAM Project Milestone 3 GUI
 * Description: Create a GUI to show the social network. Implement the
 * functionality of the Social Network to the GUI. 
 */

package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Interface for a SocialNetwork of friends
 * @author Daniel de Monteiro, Connor Hanson, Mitchell Alley, George Khankeldian
 *
 */
public interface SocialNetworkADT {
	
	/**
	 * Adds friendship between 2 users
	 * @param p1 first user
	 * @param p2 second user
	 * @return if a friendship was added
	 */
	public boolean addFriends(String p1, String p2);
	
	/**
	 * Remove friendship between 2 users
	 * @param p1 first user
	 * @param p2 second user
	 * @return if a friendship was removed
	 */
	public boolean removeFriends(String p1, String p2);
	
	/**
	 * Add user to network
	 * @param name of the user to add
	 * @return if the user was added
	 */
	public boolean addUser(String name);
	
	/**
	 * Remove user from network
	 * @param name of the user to remove
	 * @return if the user was removed
	 */
	public boolean removeUser(String name);
	
	/**
	 * Return a Set of friends of a user
	 * @param user of the user to get the friends from
	 * @return a Set of Persons of the friends of the user
	 */
	public Set<Person> getFriends(String user);
	
	/**
	 * Return a Set of mutual friends between 2 users
	 * @param user1 first user
	 * @param user2 second user
	 * @return a Set of Persons of the mutual friends of the 2 users
	 */
	public Set<Person> getMutualFriends(String user1, String user2);
	
	/**
	 * Return a List of the shortest path between 2 users
	 * @param user1 first user
	 * @param user2 second user
	 * @return a List of Persons of the shortest path between 2 users
	 */
	public List<Person> getShortestPath(String user1, String user2);
	
	/**
	 * Return a Set of connected components in the network
	 * @return a Set of Graphs of connected components in the network
	 */
	public Set<Graph> getConnectedComponents();
	
	/**
	 * Load network from a file
	 * @throws IOException
	 */
	public void loadFromFile() throws IOException;
	
	/**
	 * Save network to a file
	 * @throws IOException
	 */
	public void saveToFile() throws IOException;

}
