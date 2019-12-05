package application;

import java.util.Set;

public interface GraphADT {
	
	public boolean addEdge(Person p1, Person p2);
	
	public boolean removeEdge(Person p1, Person p2);
	
	public boolean addNode(Person p);
	
	public boolean removeNode(Person p);
	
	public Set<Person> getNeighbors(Person p);
	
	public Person getPerson(String firstName, String lastName);
	
	public Set<Person> getAllNodes();

}
