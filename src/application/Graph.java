package application;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph implements GraphADT {

	private HashMap<Person, List<Person>> adjList;

	private static Comparator<Person> NAME_COMPARATOR = new Comparator<>() {
		@Override
		public int compare(Person p1, Person p2) {
			if (p1 == null || p2 == null) {
				return -1;
			}
			
			// Case 1: They have the same name
			if (p1.getName().equals(p2.getName())) {
				//System.out.println("Same name!");
				return 0;
			}
			else {
				return p1.getName().compareTo(p2.getName());
			}

		}
	};

	public HashMap<Person, List<Person>> getUsers(){
		return adjList;
	}
	
	public Graph() {
		this.adjList = new HashMap<>();
	}

	/**
	 * Make a 1 directional edge? accepting the friend request will make it two
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
		adjList.get(p2).add(p1);

		// check to make sure it is added to the adjacency list
		if (!adjList.get(p1).contains(p2) || !adjList.get(p2).contains(p1)) {
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
		//return empty set if neighbors list is null
		if (adjList.get(p) == null)
			return neighbors;
		
		//else add neighbors to set and return set
		neighbors.addAll(adjList.get(p));
		return neighbors;
	}

	/**
	 * 
	 * 
	 */
	@Override
	public Person getPerson(String name) {
		if (name == null) {
			throw new NullPointerException();
		}
		
		Person findPerson = new Person(name);
		
		Set<Person> pplSet = adjList.keySet();
		for (Person p : pplSet) {
			if (NAME_COMPARATOR.compare(findPerson, p) == 0) {
				return p; // return the person with the same name
			}
		}
		
		return null; // doesn't contain the person
	}

	/**
	 * 
	 */
	@Override
	public Set<Person> getAllNodes() {
		return adjList.keySet();
	}
	
	/**
	 * Method to return a list of the shortest path between 2 nodes/
	 */
	public List<String> getShortestPath(String user1, String user2) {
		//Map to store parents and list to store list
		Map<String, String> parents = new HashMap<String, String>();
		List<Person> tmp = new LinkedList<Person>();
		
		//Starting person
		Person begin = this.getPerson(user1);
		tmp.add(begin);
		parents.put(user1, null);
		
		//go through all friends/users
		while (tmp.size() > 0) {
			Person current = tmp.get(0);
			Set<Person> neighbors = this.getNeighbors(current);
			
			//iterate through neighbors
			for (Person neighbor : neighbors) {
				String name = neighbor.getName();
				
				//check for visited
				boolean visited = parents.containsKey(name);
				if (visited != true) {
					tmp.add(neighbor);
					parents.put(name, current.getName());
					
					//return shortest path if reached
					if (name.equals(user2)) {
						return path(parents, user2);
					}
				}
			}
			tmp.remove(0); //remove starting
		}
		
		return null;
	}
	
	/**
	 * Private helper method to help getShortestPath by getting path
	 * @param parents map of parents
	 * @param user2 name of user2
	 * @return list of path
	 */
	private List<String> path(Map<String, String> parents, String user2) {
		List<String> path = new LinkedList<String>();
		String person = user2;
		
		//go through whole path
		while (person != null) {
			path.add(0, person);
			String parent = parents.get(person);
			person = parent;
		}
		return path;
	}

}
