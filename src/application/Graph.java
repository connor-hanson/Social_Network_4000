package application;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graph implements GraphADT {

	private HashMap<Person, List<Person>> adjList;

	public Graph() {
		adjList = new HashMap<>();
	}

	/**
	 * 
	 */
	@Override
	public boolean addEdge(Person p1, Person p2) {
		if (!adjList.containsKey(p1)) {
			addNode(p1);
		}

		if (!adjList.containsKey(p2)) {
			addNode(p2);
		}

		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 */
	@Override
	public boolean removeEdge(Person p1, Person p2) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Make sure the person doesn't already exist in the graph, if they don't
	 * add new Person to hashMap
	 * 
	 * @return false if person not added for some reason, true otherwise
	 */
	@Override
	public boolean addNode(Person p) {
		// is this going to work if we try adding a different person with the
		// same name?
		if (adjList.containsKey(p)) {
			return false;
		}

		adjList.put(p, new LinkedList<Person>());
		
		// just to make sure key is added
		if (!adjList.containsKey(p)) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 */
	@Override
	public boolean removeNode(Person p) {
		if (!adjList.containsKey(p)) {
			return false;
		}

		adjList.remove(p);
		
		if (adjList.containsKey(p)) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 */
	@Override
	public Set<Person> getNeighbors(Person p) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public Person getPerson(String name) {

		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public Set<Person> getAllNodes() {
		// TODO Auto-generated method stub
		return null;
	}

}
