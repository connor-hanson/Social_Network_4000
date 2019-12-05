package application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTests {

	private static Graph graph;

	@BeforeEach
	void setUp() throws Exception {
		graph = new Graph();
	}

	@AfterEach
	void tearDown() throws Exception {
		graph = null;
	}

	@Test
	void test000_add_5_nodes() {
		for (int i = 0; i < 5; ++i) {
			Person p = new Person("" + i, "" + i);
			if (!graph.addNode(p)) {
				fail("Graph failed to add a person named " + i);
			}
		}
	}

	@Test
	void test001_add_5_nodes_with_edges() {
		for (int i = 0; i < 5; ++i) {
			Person p = new Person("" + i, "" + i);
			graph.addNode(p);
		}

		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				Person p1 = new Person("" + i, "" + i);
				Person p2 = new Person("" + j, "" + j);

				if (!graph.addEdge(p1, p2)) {
					fail("Failed to add an edge between person " + i + " and "
							+ j);
				}
			}
		}
	}

	@Test
	void test002_add_duplicate_nodes() {
		Person p1 = new Person("Connor", "Hanson");
		Person p2 = new Person("George", "Khankeldian");
		Person p3 = new Person("Mitch", "Alley");
		Person p4 = new Person("Daniel", "DeMonteiro");

		// if any nodes were added incorrectly
		if (!graph.addNode(p1) || !graph.addNode(p2) || !graph.addNode(p3)
				|| !graph.addNode(p4)) {
			fail("Didn't add one of the nodes correctly");
		}

		if (graph.addNode(p1) || graph.addNode(p2) || graph.addNode(p3)
				|| graph.addNode(p4)) {
			fail("Added a duplicate node");
		}
	}

	@Test
	void test003_add_duplicate_edges() {
		Person p1 = new Person("Connor", "Hanson");
		Person p2 = new Person("George", "Khankeldian");
		Person p3 = new Person("Mitch", "Alley");
		Person p4 = new Person("Daniel", "DeMonteiro");
		
		if (!graph.addEdge(p1, p2) || !graph.addEdge(p3, p4)) {
			fail("Didnt add nodes or edge correctly");
		}
		
		if (graph.addEdge(p1, p2) || graph.addEdge(p3, p4)) {
			fail("Added duplicate edge");
		}
	}
	
	@Test 
	void test004_getPerson() {
		Person p1 = new Person("Connor", "Hanson");
		Person p2 = new Person("George", "Khankeldian");
		Person p3 = new Person("Mitch", "Alley");
		Person p4 = new Person("Daniel", "DeMonteiro");
		
		if (!graph.addNode(p1) || !graph.addNode(p2) || !graph.addNode(p3)
				|| !graph.addNode(p4)) {
			fail("Didn't add one of the nodes correctly");
		}
		
		
		if (!graph.getPerson("Connor", "Hanson").equals(p1)) {
			fail("getPerson method working incorrectly");
		}
	}
	
	@Test
	void test005_getAllNodes() {
		Person p1 = new Person("Connor", "Hanson");
		Person p2 = new Person("George", "Khankeldian");
		Person p3 = new Person("Mitch", "Alley");
		Person p4 = new Person("Daniel", "DeMonteiro");
		
		graph.addEdge(p1, p2);
		graph.addEdge(p3, p4);
		
		LinkedHashSet<Person> correctSet = new LinkedHashSet<>();
		correctSet.add(p1);
		correctSet.add(p2);
		correctSet.add(p3);
		correctSet.add(p4);
		
		Set<Person> retSet = graph.getAllNodes();
		
		for (Person p : correctSet) {
			if (!retSet.contains(p)) {
				fail("returned set doesnt contain node " + p.toString());
			}
		}
	}
	
	@Test
	void test006_getNeighbors() {
		Person p1 = new Person("Connor", "Hanson");
		Person p2 = new Person("George", "Khankeldian");
		Person p3 = new Person("Mitch", "Alley");
		Person p4 = new Person("Daniel", "DeMonteiro");
		
		graph.addEdge(p1, p2);
		graph.addEdge(p1, p3);
		graph.addEdge(p1, p4);
		
		graph.addEdge(p2, p3);
		graph.addEdge(p2, p4);
		
		LinkedHashSet<Person> p1Neighbors = new LinkedHashSet<>();
		LinkedHashSet<Person> p2Neighbors = new LinkedHashSet<>();
		
		p1Neighbors.add(p2);
		p1Neighbors.add(p3);
		p1Neighbors.add(p4);
		
		p2Neighbors.add(p3);
		p2Neighbors.add(p4);
		
		Set<Person> p1Ret = graph.getNeighbors(p1);
		Set<Person> p2Ret = graph.getNeighbors(p2);
		
		for (Person p : p1Neighbors) {
			if (!p1Ret.contains(p)) {
				fail("p1.getNeighbors didn't have " + p);
			}
		}
		
		for (Person p : p2Neighbors) {
			if (!p2Ret.contains(p)) {
				fail("p2.getNeighbors didn't have " + p);
			}
		}
		
		if (p2Ret.contains(p1)) {
			fail("p2 shouldn't have p1 as a friend");
		}
	}
}
