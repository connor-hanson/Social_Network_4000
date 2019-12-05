package application;

import java.util.List;
import java.util.Set;

public class SocialNetwork implements SocialNetworkADT {
	
	private Graph graph;
	
	public SocialNetwork() {
		
	}

	@Override
	public boolean addFriends(String p1, String p2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeFriends(String p1, String p2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeUser(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Person> getFriends(String user) {
		// TODO Auto-generated method stub
		return null;
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
