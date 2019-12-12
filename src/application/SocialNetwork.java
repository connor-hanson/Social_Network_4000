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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Class that implements SocialNetworkADT and creates a SocialNetwork
 * @author Daniel de Monteiro, Connor Hanson, Mitchell Alley, George Khankeldian
 *
 */
public class SocialNetwork implements SocialNetworkADT {

	private Graph graph; //graph to use for SocialNetwork
	private File log; // different from the save file
	private String networkName; //Name of network
	private PrintWriter fileWriter; //fileWriter to write to files

	/**
	 * Ensures that the name ends in .txt
	 * ex, if user inputs network, passed to this class as network.txt
	 * if user inputs network.txt, nothing is changed
	 * @param networkName name of Network
	 */
	public SocialNetwork(String networkName) {
		graph = new Graph();
		this.networkName = networkName;
		this.log = new File("LogFiles/log.txt"); // intentionally overwritten
													// every time
		// the program is run

		try {
			this.fileWriter = new PrintWriter(log);
		} catch (IOException e) {
			System.err.print("Error loading PrintWriter for log.txt");
			System.err.print(e.getMessage());
		}
	}
	
	/**
	 * Checks if user already exists in network
	 * @param name of user to check
	 * @return if user exists in graph
	 */
	public boolean isAlreadyUser(String name) {
		if (name == null)
			return false;
		if (graph.getPerson(name) == null) 
			return false;		
		else 
			return true;
	}

	/**
	 * Get Person from name
	 * @param name of Person to get
	 * @return the Person with given namee
	 */
	private Person getPerson(String name) {
		return graph.getPerson(name);	
	}

	/**
	 * Add a friendship between 2 users
	 */
	@Override
	public boolean addFriends(String name1, String name2) {
		if (name1 == null || name2 == null)
			return false;
		Person p1 = getPerson(name1);
		Person p2 = getPerson(name2);

		fileWriter.println("-a " + name1 + " " + name2);
		fileWriter.flush();

		return graph.addEdge(p1, p2);
	}

	/**
	 * Remove friends between 2 users
	 */
	@Override
	public boolean removeFriends(String name1, String name2) {
		if (name1 == null || name2 == null)
			return false;
		Person p1 = getPerson(name1);
		Person p2 = getPerson(name2);

		fileWriter.println("-r " + name1 + " " + name2);
		fileWriter.flush();

		return graph.removeEdge(p1, p2);
	}

	/**
	 * Add a user to the network
	 */
	@Override
	public boolean addUser(String name) {
		if (name == null)
			return false;
		Person p = new Person(name);

		fileWriter.println("-a " + name);
		fileWriter.flush();

		return graph.addNode(p);
	}

	/**
	 * Remove user from network
	 */
	@Override
	public boolean removeUser(String name) {
		if (name == null)
			return false;
		Person p = getPerson(name);

		fileWriter.println("-r " + name);
		fileWriter.flush();

		return graph.removeNode(p);
	}

	/**
	 * Get a Set of friends of a user
	 */
	@Override
	public Set<Person> getFriends(String user) {
		if (user == null)
			return null;
		LinkedHashSet<Person> emptySet = new LinkedHashSet<>();
		Person p = getPerson(user);
		if (graph.getNeighbors(p) != null)
			return graph.getNeighbors(p);
		else
			return emptySet;
	}

	/*
	 * Get mutual friends between 2 users
	 */
	@Override
	public Set<Person> getMutualFriends(String user1, String user2) {
		if (user1 == null || user2 == null)
			return null;
		HashMap<Person, List<Person>> tmp = graph.getUsers();
		List<Person> user1Friends = tmp.get(getPerson(user1));
		List<Person> user2Friends = tmp.get(getPerson(user2));
		HashSet<Person> returnVal = new HashSet<Person>();
		
		for (Person p : user1Friends) {
			if (user2Friends.contains(p)) {
				returnVal.add(p);
			}
		}
		return returnVal;
	}

	/**
	 * Method to return a list of the shortest path between 2 nodes/
	 */
	@Override
	public List<Person> getShortestPath(String user1, String user2) {
		//get path of strings from graph
		List<String> stringPath = this.graph.getShortestPath(user1, user2);
		
		if(stringPath == null) {
		    return null;
		}
		
		//List for Persons to be stored
		List<Person> personPath = new LinkedList<>();
		
		//iterate througuh stringPath and add respective person to personPath
		for (String s : stringPath) {
			personPath.add(this.getPerson(s));
		}
		
		return personPath;
	}

	/**
	 * Depth first serach of the network
	 * @param person to run the search on
	 * @param unvisited users
	 * @return Graph of a DFS on person
	 */
	public Graph depthFirstSearch(Person person, ArrayList<Person> unvisited) {
		HashMap<Person, List<Person>> list = graph.getUsers();
		ArrayList<Person> visited = new ArrayList<Person>();
		LinkedList<Person> queue = new LinkedList<Person>();
		
		Graph returnVal = new Graph();
		
		//algorithm
		visited.add(person);
		unvisited.remove(person);
		queue.add(person);
		while(!queue.isEmpty()) {
			Person p = queue.remove();
			for (Person s : list.get(p)) {
				if (unvisited.contains(s)) {
					returnVal.addNode(s);
					returnVal.addEdge(p, s);
					visited.add(s);
					unvisited.remove(s);
					queue.add(s);
				}
			}
		}
		
		
		return returnVal;
	}

	/**
	 * Return set of connected components
	 */
	@Override
	public Set<Graph> getConnectedComponents() {
		ArrayList<Person> allPeople = new ArrayList<Person>();
		Set<Person> list = graph.getUsers().keySet();
		HashSet<Graph> returnVal = new HashSet<Graph>();
		for (Person p : list) {
			if (p != null)
				allPeople.add(p);
		}
		
		
		while((allPeople.size() != 0)) {
			returnVal.add(depthFirstSearch(allPeople.get(0), allPeople));
		}
		return returnVal;
	}
	
	/**
	 * Load Network from a file
	 */
	@Override
	public void loadFromFile() throws IOException {
		File loadFile = new File("LogFiles/" + networkName);
		//PrintWriter loadWriter = new PrintWriter(loadFile);
		Scanner sc = new Scanner(loadFile);

		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] command = line.split(" "); // splits into array based on
												// how many spaces there are
			
			// a node command
			if (command.length == 2) {
				if (command[0].equals("-a")) {
					addUser(command[1]);
				} else if (command[0].equals("-r")) {
					removeUser(command[1]);
				} else {
					System.err.println("Invalid command!");
				}
			} 
			
			// an edge command
			else if (command.length == 3) {
				if (command[0].equals("-a")) {
					addFriends(command[1], command[2]);
				} else if (command[0].equals("-r")) {
					removeFriends(command[1], command[2]);
				} else {
					System.err.println("Invalid command!");
				}
			}
			
			else {
				System.err.println("Invalid command length!");
			}
		}
		
		sc.close();
	}

	/**
	 * Only saves the adds/removes performed on this network
	 */
	@Override
	public void saveToFile() throws IOException {
		File saveFile = new File("LogFiles/" + networkName); // shouldn't have
																// to append
																// .txt
		// since that is done in main
		PrintWriter saveWriter = new PrintWriter(saveFile);
		Scanner sc = new Scanner(log); // used to read through every line of
										// the log file
		while (sc.hasNext()) { // until there are no more lines
			String line = sc.nextLine();
			saveWriter.println(line);
			saveWriter.flush();
			System.out.println(line);
		}

		sc.close();
		saveWriter.close();

		// TODO Auto-generated method stub

	}
	
	/**
	 * Method to return a set of all users in the network
	 * @return set of all users in network
	 */
	public Set<Person> allUsers() {
		return this.graph.getAllNodes();
	}
	
	/**
	 * Private helper method to reset the network
	 */
	public void resetNetwork() {
		//Replace current graph with a new graph
		this.graph = new Graph();
	}

}
