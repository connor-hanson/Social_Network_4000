package application;

import java.util.List;
import java.util.Set;

public interface SocialNetworkADT {
	
	public boolean addFriends(String p1, String p2);
	
	public boolean removeFriends(String p1, String p2);
	
	public boolean addUser(String name);
	
	public boolean removeUser(String name);
	
	public Set<Person> getFriends(String user);
	
	public Set<Person> getMutualFriends(String user1, String user2);
	
	public List<Person> getShortestPath(String user1, String user2);
	
	public Set<Graph> getConnectedComponents();
	
	public void loadFromFile();
	
	public void saveToFile();

}
