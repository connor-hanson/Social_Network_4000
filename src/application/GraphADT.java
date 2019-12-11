package application;

import java.util.Set;

public interface GraphADT {
	
	/**
	 * Adds an edge between two Persons
	 * @param p1 the first Person
	 * @param p2 the second Person
	 * @return if an edge was added
	 */
	public boolean addEdge(Person p1, Person p2);
	
	/**
	 * Removes san edge between two Persons
	 * @param p1 the first Person
	 * @param p2 the second Person
	 * @return if an edge was removed
	 */
	public boolean removeEdge(Person p1, Person p2);
	
	/**
	 * Adds a node(Person) to the graph
	 * @param p the Person to add
	 * @return if a Person was added
	 */
	public boolean addNode(Person p);
	
	/**
	 * Remove a node(Person_ from the graph
	 * @param p the Person to remove
	 * @return if a Perosn was removed
	 */
	public boolean removeNode(Person p);
	
	/**
	 * Get neighbors of a Person
	 * @param p the Person to get the neighbors of
	 * @return a Set of Persons of p's neighbors
	 */
	public Set<Person> getNeighbors(Person p);
	
	/**
	 * Return the Person from a given name
	 * @param name the name of the Person
	 * @return the Person with the given name
	 */
	public Person getPerson(String name);
	
	/**
	 * Return all nodes(Persons in graph)
	 * @return a Set of Persons of all Persons(nodes) in graph
	 */
	public Set<Person> getAllNodes();

}
