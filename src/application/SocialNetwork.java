package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SocialNetwork implements SocialNetworkADT {

	private Graph graph;
	private File log; // different from the save file
	private String networkName;
	private PrintWriter fileWriter;

	// TODO add every action to the log, which is saved when the save method is
	// called

	// Main class ensures that the name ends in .txt
	// ex, if user inputs network, passed to this class as network.txt
	// if user inputs network.txt, nothing is changed
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

	private Person getPerson(String name) {
		return graph.getPerson(name);
//		HashMap<Person, List<Person>> list = graph.getUsers();
//
//		Iterator<?> it = list.entrySet().iterator();
//		// Person one; Seems like these were unused?
//		// Person two;
//		while (it.hasNext()) {
//			Map.Entry mapElement = (Map.Entry) it.next(); // Whoever wrote this
//															// needs to add type
//															// arguments, idk
//															// what is happening
//															// here
//			if (((Person) mapElement.getKey()).getName().equals(name)) {
//				return (Person) (mapElement).getKey();
//			}
//		}
//		return null;
	}

	@Override
	public boolean addFriends(String name1, String name2) {
		Person p1 = getPerson(name1);
		Person p2 = getPerson(name2);

		fileWriter.println("-a " + name1 + " " + name2);
		fileWriter.flush();

		return graph.addEdge(p1, p2);
	}

	@Override
	public boolean removeFriends(String name1, String name2) {
		Person p1 = getPerson(name1);
		Person p2 = getPerson(name2);

		fileWriter.println("-r " + name1 + " " + name2);
		fileWriter.flush();

		return graph.removeEdge(p1, p2);
	}

	@Override
	public boolean addUser(String name) {
		Person p = new Person(name);

		fileWriter.println("-a " + name);
		fileWriter.flush();

		return graph.addNode(p);
	}

	@Override
	public boolean removeUser(String name) {
		Person p = getPerson(name);

		fileWriter.println("-r " + name);
		fileWriter.flush();

		return graph.removeNode(p);
	}

	@Override
	public Set<Person> getFriends(String user) {
		LinkedHashSet<Person> emptySet = new LinkedHashSet<>();
		Person p = getPerson(user);
		if (graph.getNeighbors(p) != null)
			return graph.getNeighbors(p);
		else
			return emptySet;
	}

	@Override
	public Set<Person> getMutualFriends(String user1, String user2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getShortestPath(String user1, String user2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Graph> getConnectedComponents() {
		// TODO Auto-generated method stub
		return null;
	}

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

		// TODO Auto-generated method stub

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

}
