package application;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graph implements GraphADT {

	private HashMap<Person, List<Person>> adjList;

	private static Comparator<Person> NAME_COMPARATOR = new Comparator<>() {
		@Override
		public int compare(Person p1, Person p2) {
			// Case 1: They have the same name
			if (p1.getFirstName().equals(p2.getFirstName())
					&& p1.getLastName().equals(p2.getLastName())) {
				return 0;
			}

			// Case 2: same last name, sort by first name
			else if (p1.getLastName().equals(p2.getLastName())) {
				return p1.getFirstName().compareTo(p2.getFirstName());
			}

			// Case 3: different last name, sort by last name
			else {
				return p1.getLastName().compareTo(p2.getLastName());
			}

		}
	};

	public Graph() {
		adjList = new HashMap<>();
	}

	/**
	 * Make a 1 directional edge, accepting the friend request will make it two
	 * way
	 */
	@Override
	public boolean addEdge(Person p1, Person p2) {
		if (!adjList.containsKey(p1)) {
			addNode(p1);
		}

		if (!adjList.containsKey(p2)) {
			addNode(p2);
		}

		if (adjList.get(p1).contains(p2)) {
			return false; // key is already in the AL
		}
		
		adjList.get(p1).add(p2);

		// check to make sure it is added to the adjacency list
		if (!adjList.get(p1).contains(p2)) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 */
	@Override
	public boolean removeEdge(Person p1, Person p2) {
		if (!adjList.containsKey(p1) || !adjList.containsKey(p2)) {
			return false; // can't remove edge if one node does not exist
		} else {
			adjList.get(p1).remove(p2);

			// if there is a two way edge
			if (adjList.get(p2).contains(p1)) {
				adjList.get(p2).remove(p1);
			}

			return true;
		}
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
		LinkedHashSet<Person> neighbors = new LinkedHashSet<>();
		neighbors.addAll(adjList.get(p));
		return neighbors;
	}

	/**
	 * NOTE: Changed parameters from String name to String firstName & String
	 * lastName. Make a note to instructors when turning in or change the Person
	 * class
	 * 
	 * 
	 */
	@Override
	public Person getPerson(String firstName, String lastName) {
		Person findPerson = new Person(firstName, lastName);

		if (!adjList.containsKey(findPerson)) {
			return null; // person doesn't exist in the list
		} else {
			Set<Person> personSet = adjList.keySet();
			for (Person p : personSet) {
				if (NAME_COMPARATOR.compare(findPerson, p) == 0) {
					return p; // return the person object with the same name
				}
			}

			// if for some reason it was not found
			return null;

		}
		// TODO Auto-generated method stub
	}

	/**
	 * 
	 */
	@Override
	public Set<Person> getAllNodes() {
		return adjList.keySet();
	}

}
