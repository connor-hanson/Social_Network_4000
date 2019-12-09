package application;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SocialNetwork implements SocialNetworkADT {
	
	private Graph graph;
	private File log;
	private String networkName;
	
	public SocialNetwork() {
		graph = new Graph();
		log = new File("log.txt");
	}
	
	private Person getPerson(String name) {
		HashMap<Person, List<Person>> list = graph.getUsers();
		
		Iterator it = list.entrySet().iterator();
		Person one;
		Person two;
		while(it.hasNext()) {
			Map.Entry mapElement = (Map.Entry)it.next();
			if(((Person)mapElement.getKey()).getName().equals(name)) {
				return (Person)(mapElement).getKey();
			}
		}
		return null;
	}

	@Override
	public boolean addFriends(String name1, String name2) {
		Person p1 = getPerson(name1);
		Person p2 = getPerson(name2);
		
		return graph.addEdge(p1, p2);
	}

	@Override
	public boolean removeFriends(String name1, String name2) {
		Person p1 = getPerson(name1);
		Person p2 = getPerson(name2);

		return graph.removeEdge(p1, p2);
	}

	@Override
	public boolean addUser(String name) {
		Person p = new Person(name);
		return graph.addNode(p);
	}

	@Override
	public boolean removeUser(String name) {
		Person p = getPerson(name);
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
	public void loadFromFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveToFile() {
		// TODO Auto-generated method stub
		
	}

}
