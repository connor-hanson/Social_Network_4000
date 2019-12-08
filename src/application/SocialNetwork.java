package application;

import java.io.File;
import java.util.List;
import java.util.Set;

public class SocialNetwork implements SocialNetworkADT {
	
	private Graph graph;
	private File log;
	
	public SocialNetwork() {
		graph = new Graph();
		log = new File("log.txt");
	}
	
	private Person createPerson(String name) {
		String[] fullName = name.split(" ");
		return new Person(fullName[0], fullName[1]);
	}

	@Override
	public boolean addFriends(String name1, String name2) {
		Person p1 = createPerson(name1);
		Person p2 = createPerson(name2);
		
		return graph.addEdge(p1, p2);
	}

	@Override
	public boolean removeFriends(String name1, String name2) {
		Person p1 = createPerson(name1);
		Person p2 = createPerson(name2);

		return graph.removeEdge(p1, p2);
	}

	@Override
	public boolean addUser(String name) {
		Person p = createPerson(name);
		return graph.addNode(p);
	}

	@Override
	public boolean removeUser(String name) {
		Person p = createPerson(name);
		return graph.removeNode(p);
	}

	@Override
	public Set<Person> getFriends(String user) {
		Person p = createPerson(user);
		return graph.getNeighbors(p);
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
